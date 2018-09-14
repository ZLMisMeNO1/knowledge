package cn.i7baoz.gen.codegen.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.config.GeneratedKey;

/** 批量新增xml生成
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class BatchInsertElementGenerator extends AbstractXmlElementGenerator {

    private boolean isSimple;

    public BatchInsertElementGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }

    @Override
    public void addElements(XmlElement parentElement) {

        XmlElement answer = new XmlElement("insert");

        answer.addAttribute(new Attribute("id", "batchInsert")); //$NON-NLS-1$

        FullyQualifiedJavaType parameterType;
        if (isSimple) {
            parameterType = new FullyQualifiedJavaType(
                    introspectedTable.getBaseRecordType());
        } else {
            parameterType = introspectedTable.getRules()
                    .calculateAllFieldsClass();
        }

        answer.addAttribute(new Attribute("parameterType", "java.util.List"));

        context.getCommentGenerator().addComment(answer);

        GeneratedKey gk = introspectedTable.getGeneratedKey();
        if (gk != null) {
            IntrospectedColumn introspectedColumn = introspectedTable
                    .getColumn(gk.getColumn());
            // if the column is null, then it's a configuration error. The
            // warning has already been reported
            if (introspectedColumn != null) {
                if (gk.isJdbcStandard()) {
                    answer.addAttribute(new Attribute(
                            "useGeneratedKeys", "true")); //$NON-NLS-1$ //$NON-NLS-2$
                    answer.addAttribute(new Attribute(
                            "keyProperty", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
                } else {
                    answer.addElement(getSelectKey(introspectedColumn, gk));
                }
            }
        }

        StringBuilder insertClause = new StringBuilder();
        StringBuilder valuesClause = new StringBuilder();

        insertClause.append("insert into "); //$NON-NLS-1$
        insertClause.append(introspectedTable
                .getFullyQualifiedTableNameAtRuntime());
        insertClause.append(" ("); //$NON-NLS-1$

        valuesClause.append(" ("); //$NON-NLS-1$

        List<String> valuesClauses = new ArrayList<String>();
        Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns()
                .iterator();
        while (iter.hasNext()) {
            IntrospectedColumn introspectedColumn = iter.next();
            if (introspectedColumn.isIdentity()) {
                // cannot set values on identity fields
                continue;
            }

            insertClause.append(MyBatis3FormattingUtilities
                    .getEscapedColumnName(introspectedColumn));
            valuesClause.append(MyBatis3FormattingUtilities
                    .getParameterClause(introspectedColumn,"bean."));
            if (iter.hasNext()) {
                insertClause.append(", "); //$NON-NLS-1$
                valuesClause.append(", "); //$NON-NLS-1$
            }

            if (valuesClause.length() > 80) {
                answer.addElement(new TextElement(insertClause.toString()));
                insertClause.setLength(0);
                OutputUtilities.xmlIndent(insertClause, 1);

                valuesClauses.add(valuesClause.toString());
                valuesClause.setLength(0);
                OutputUtilities.xmlIndent(valuesClause, 1);
            }
        }

        insertClause.append(')');
        insertClause.append(" values ");
        answer.addElement(new TextElement(insertClause.toString()));

        valuesClause.append(')');
        valuesClauses.add(valuesClause.toString());

        XmlElement foreach = new XmlElement("foreach");
        foreach.addAttribute(new Attribute("collection", "list"));
        foreach.addAttribute(new Attribute("item", "bean"));
        foreach.addAttribute(new Attribute("index", "index"));
        foreach.addAttribute(new Attribute("separator", ","));
        for (String clause : valuesClauses) {
            foreach.addElement(new TextElement(clause));
        }

        answer.addElement(foreach);
        if (context.getPlugins().sqlMapInsertElementGenerated(answer,
                introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
