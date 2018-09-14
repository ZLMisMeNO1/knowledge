package cn.i7baoz.gen.codegen.xml;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class BatchUpdateChangedElementGenerator extends AbstractXmlElementGenerator {

    private boolean isSimple;

    public BatchUpdateChangedElementGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }

    @Override
    public void addElements(XmlElement parentElement) {

        XmlElement answer = new XmlElement("update");
        answer.addElement(new TextElement("update " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        answer.addAttribute(new Attribute("id", "batchUpdateChanged"));

        answer.addAttribute(new Attribute("parameterType", "java.util.List"));

        context.getCommentGenerator().addComment(answer);

        XmlElement dynamicElement = new XmlElement("trim");
        dynamicElement.addAttribute(new Attribute("prefix", "set"));
        dynamicElement.addAttribute(new Attribute("suffixOverrides", ","));

        String columnName;
        String javaName;
        StringBuilder sb;
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getAllColumns()) {
            if (introspectedTable.getPrimaryKeyColumns() != null &&
                    introspectedTable.getPrimaryKeyColumns().contains(introspectedColumn)) {
                //id不允许更改
                continue;
            }
            sb = new StringBuilder();
            columnName = MyBatis3FormattingUtilities
                    .getAliasedEscapedColumnName(introspectedColumn);
            javaName = introspectedColumn.getJavaProperty();
            XmlElement trimElement = new XmlElement("trim");
            trimElement.addAttribute(new Attribute("prefix", columnName + " =case"));
            trimElement.addAttribute(new Attribute("suffix", "end,"));
            XmlElement foreach = new XmlElement("foreach");
            foreach.addAttribute(new Attribute("collection", "list"));
            foreach.addAttribute(new Attribute("item", "i"));
            foreach.addAttribute(new Attribute("index", "index"));
            XmlElement ifElement = new XmlElement("if");
            ifElement.addAttribute(new Attribute("test", "i." + javaName + "!=null"));
            for (IntrospectedColumn primartColumn : introspectedTable
                    .getPrimaryKeyColumns()) {
                sb.append("when ");
                sb.append(MyBatis3FormattingUtilities
                        .getEscapedColumnName(primartColumn) + " = ");
                sb.append(MyBatis3FormattingUtilities.getParameterClause(primartColumn,"i."));
                sb.append(" then ");
                sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "i."));
            }

            ifElement.addElement(new TextElement(sb.toString()));
            foreach.addElement(ifElement);
            trimElement.addElement(foreach);
            dynamicElement.addElement(trimElement);
        }
        answer.addElement(dynamicElement);
        answer.addElement(new TextElement(" where "));
        XmlElement foreach = new XmlElement("foreach");
        foreach.addAttribute(new Attribute("collection","list"));
        foreach.addAttribute(new Attribute("separator","or"));
        foreach.addAttribute(new Attribute("item","i"));
        foreach.addAttribute(new Attribute("index","index"));
        for (IntrospectedColumn primartColumn : introspectedTable
                .getPrimaryKeyColumns()) {
            sb = new StringBuilder();
            sb.append(MyBatis3FormattingUtilities
                    .getEscapedColumnName(primartColumn) + " = ");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(primartColumn,"i."));
            foreach.addElement(new TextElement(sb.toString()));
        }
        answer.addElement(foreach);
//        answer.addElement(getUpdateByExampleIncludeElement());

        if (context.getPlugins()
                .sqlMapUpdateByExampleSelectiveElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
