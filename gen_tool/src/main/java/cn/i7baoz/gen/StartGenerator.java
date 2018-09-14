package cn.i7baoz.gen;

import cn.i7baoz.gen.factory.MyConfiguration;
import cn.i7baoz.gen.generator.MyBatisGenerator;
import cn.i7baoz.gen.parser.MyConfigurationParser;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class StartGenerator {

    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
            MyConfigurationParser cp = new MyConfigurationParser(warnings);
            MyConfiguration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("使用此方法生成时请注意：");
            System.out.println("在generatorConfig.xml配置中");
            System.out.println("1. javaModelGenerator标签中targetProject应使用绝对路径");
            System.out.println("2. sqlMapGenerator标签中targetProject应使用绝对路径");
            System.out.println("3. javaClientGenerator标签中targetProject应使用绝对路径");
            System.out.println("success generator");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
    }
}
