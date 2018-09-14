package cn.i7baoz.gen.codegen.javamapper;

import java.util.Set;
import java.util.TreeSet;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

/**
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class BatchUpdateChangedMethodGenerator extends AbstractJavaMapperMethodGenerator  {
    boolean isSimple;

    public BatchUpdateChangedMethodGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }
    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();

        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setVisibility(JavaVisibility.PUBLIC);
        //设置方法名
        method.setName("batchUpdateChanged");
        //设置参数为List类型
        FullyQualifiedJavaType parameterType = FullyQualifiedJavaType
                .getNewListInstance();
        //设置泛型
        parameterType.addTypeArgument(new FullyQualifiedJavaType(
                introspectedTable.getBaseRecordType()));

        importedTypes.add(parameterType);
        //引入@Param注解
        importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        //参数配置
        method.addParameter(new Parameter(parameterType, "list","@Param(\"list\")",false)); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        if (context.getPlugins().clientInsertMethodGenerated(method, interfaze,
                introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
        return;
    }
}
