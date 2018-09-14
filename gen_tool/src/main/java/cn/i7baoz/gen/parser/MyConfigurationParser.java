package cn.i7baoz.gen.parser;

import cn.i7baoz.gen.factory.MyConfiguration;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.config.xml.IbatorConfigurationParser;
import org.mybatis.generator.config.xml.ParserEntityResolver;
import org.mybatis.generator.config.xml.ParserErrorHandler;
import org.mybatis.generator.exception.XMLParserException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class MyConfigurationParser {

    private List<String> warnings;
    private List<String> parseErrors;
    private Properties properties;

    public MyConfigurationParser(List<String> warnings) {
        this(null, warnings);
    }

    public MyConfigurationParser(Properties properties, List<String> warnings) {
        super();
        if (properties == null) {
            this.properties = System.getProperties();
        } else {
            this.properties = properties;
        }

        if (warnings == null) {
            this.warnings = new ArrayList<String>();
        } else {
            this.warnings = warnings;
        }

        parseErrors = new ArrayList<String>();
    }

    public MyConfiguration parseConfiguration(File inputFile) throws IOException,
            XMLParserException {

        FileReader fr = new FileReader(inputFile);

        return parseConfiguration(fr);
    }

    public MyConfiguration parseConfiguration(Reader reader) throws IOException,
            XMLParserException {

        InputSource is = new InputSource(reader);

        return parseConfiguration(is);
    }

    public MyConfiguration parseConfiguration(InputStream inputStream)
            throws IOException, XMLParserException {

        InputSource is = new InputSource(inputStream);

        return parseConfiguration(is);
    }

    private MyConfiguration parseConfiguration(InputSource inputSource)
            throws IOException, XMLParserException {
        parseErrors.clear();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(new ParserEntityResolver());

            ParserErrorHandler handler = new ParserErrorHandler(warnings,
                    parseErrors);
            builder.setErrorHandler(handler);

            Document document = null;
            try {
                document = builder.parse(inputSource);
            } catch (SAXParseException e) {
                throw new XMLParserException(parseErrors);
            } catch (SAXException e) {
                if (e.getException() == null) {
                    parseErrors.add(e.getMessage());
                } else {
                    parseErrors.add(e.getException().getMessage());
                }
            }

            if (parseErrors.size() > 0) {
                throw new XMLParserException(parseErrors);
            }

            MyConfiguration config;
            Element rootNode = document.getDocumentElement();
            DocumentType docType = document.getDoctype();
            config = parseMyBatisGeneratorConfiguration(rootNode);
           if (rootNode.getNodeType() == Node.ELEMENT_NODE
                    && XmlConstants.MYBATIS_GENERATOR_CONFIG_PUBLIC_ID.equals(
                    docType.getPublicId())) {
                config = parseMyBatisGeneratorConfiguration(rootNode);
            }else {
                //加入本地dtd
                config = parseMyBatisGeneratorConfiguration(rootNode);
//                throw new XMLParserException(getString("RuntimeError.5")); //$NON-NLS-1$
            }

            if (parseErrors.size() > 0) {
                throw new XMLParserException(parseErrors);
            }

            return config;
        } catch (ParserConfigurationException e) {
            parseErrors.add(e.getMessage());
            throw new XMLParserException(parseErrors);
        }
    }

    private MyConfiguration parseMyBatisGeneratorConfiguration(Element rootNode)
            throws XMLParserException {
        //这里重写为自定义的parser
        MyBatisGeneratorConfigurationParser parser = new MyBatisGeneratorConfigurationParser(
                properties);
        return parser.parseConfiguration(rootNode);
    }
}
