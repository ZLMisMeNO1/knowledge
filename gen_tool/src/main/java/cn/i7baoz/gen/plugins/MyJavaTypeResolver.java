package cn.i7baoz.gen.plugins;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * tinyint转为Integer 非byte
 * @author LIYING360
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public MyJavaTypeResolver() {
        this.typeMap.put(Integer.valueOf(-6), new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
