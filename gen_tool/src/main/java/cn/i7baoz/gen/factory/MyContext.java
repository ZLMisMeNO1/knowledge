package cn.i7baoz.gen.factory;

import static org.mybatis.generator.internal.util.StringUtility.composeFullyQualifiedTableName;
import static org.mybatis.generator.internal.util.StringUtility.isTrue;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import cn.i7baoz.gen.config.MyTableConfiguration;
import cn.i7baoz.gen.introspector.MyDatabaseIntrospector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.XmlFormatter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.internal.PluginAggregator;
import org.mybatis.generator.internal.db.ConnectionFactory;

/**解析generatorConfiguration.xml
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class MyContext extends Context {

    private String id;

    private JDBCConnectionConfiguration jdbcConnectionConfiguration;

    private SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration;

    private JavaTypeResolverConfiguration javaTypeResolverConfiguration;

    private JavaModelGeneratorConfiguration javaModelGeneratorConfiguration;

    private JavaClientGeneratorConfiguration javaClientGeneratorConfiguration;

    private ArrayList<MyTableConfiguration> tableConfigurations;

    private ModelType defaultModelType;

    private String beginningDelimiter = "\""; //$NON-NLS-1$

    private String endingDelimiter = "\""; //$NON-NLS-1$

    private CommentGeneratorConfiguration commentGeneratorConfiguration;

    private CommentGenerator commentGenerator;

    private PluginAggregator pluginAggregator;

    private List<PluginConfiguration> pluginConfigurations;

    private String targetRuntime;

    private String introspectedColumnImpl;

    private Boolean autoDelimitKeywords;

    private JavaFormatter javaFormatter;

    private XmlFormatter xmlFormatter;

    /**
     * Constructs a Context object.
     *
     * @param defaultModelType
     *            - may be null
     */
    public MyContext(ModelType defaultModelType) {
        super(defaultModelType);

        if (defaultModelType == null) {
            this.defaultModelType = ModelType.CONDITIONAL;
        } else {
            this.defaultModelType = defaultModelType;
        }

        tableConfigurations = new ArrayList<MyTableConfiguration>();
        pluginConfigurations = new ArrayList<PluginConfiguration>();
    }

    public void addTableConfiguration(MyTableConfiguration tc) {
        tableConfigurations.add(tc);
    }
    @Override
    public JDBCConnectionConfiguration getJdbcConnectionConfiguration() {
        return jdbcConnectionConfiguration;
    }
    @Override
    public JavaClientGeneratorConfiguration getJavaClientGeneratorConfiguration() {
        return javaClientGeneratorConfiguration;
    }
    @Override
    public JavaModelGeneratorConfiguration getJavaModelGeneratorConfiguration() {
        return javaModelGeneratorConfiguration;
    }
    @Override
    public JavaTypeResolverConfiguration getJavaTypeResolverConfiguration() {
        return javaTypeResolverConfiguration;
    }
    @Override
    public SqlMapGeneratorConfiguration getSqlMapGeneratorConfiguration() {
        return sqlMapGeneratorConfiguration;
    }
    @Override
    public void addPluginConfiguration(
            PluginConfiguration pluginConfiguration) {
        pluginConfigurations.add(pluginConfiguration);
    }

    /**
     * This method does a simple validate, it makes sure that all required
     * fields have been filled in. It does not do any more complex operations
     * such as validating that database tables exist or validating that named
     * columns exist
     */
    @Override
    public void validate(List<String> errors) {
        if (!stringHasValue(id)) {
            errors.add(getString("ValidationError.16")); //$NON-NLS-1$
        }

        if (jdbcConnectionConfiguration == null) {
            errors.add(getString("ValidationError.10", id)); //$NON-NLS-1$
        } else {
            jdbcConnectionConfiguration.validate(errors);
        }

        if (javaModelGeneratorConfiguration == null) {
            errors.add(getString("ValidationError.8", id)); //$NON-NLS-1$
        } else {
            javaModelGeneratorConfiguration.validate(errors, id);
        }

        if (javaClientGeneratorConfiguration != null) {
            javaClientGeneratorConfiguration.validate(errors, id);
        }

        IntrospectedTable it = null;
        try {
            it = MyObjectFactory.createIntrospectedTableForValidation(this);
        } catch (Exception e) {
            errors.add(getString("ValidationError.25", id)); //$NON-NLS-1$
        }

        if (it != null && it.requiresXMLGenerator()) {
            if (sqlMapGeneratorConfiguration == null) {
                errors.add(getString("ValidationError.9", id)); //$NON-NLS-1$
            } else {
                sqlMapGeneratorConfiguration.validate(errors, id);
            }
        }

        if (tableConfigurations.size() == 0) {
            errors.add(getString("ValidationError.3", id)); //$NON-NLS-1$
        } else {
            for (int i = 0; i < tableConfigurations.size(); i++) {
                MyTableConfiguration tc = tableConfigurations.get(i);

                tc.validate(errors, i);
            }
        }

        for (PluginConfiguration pluginConfiguration : pluginConfigurations) {
            pluginConfiguration.validate(errors, id);
        }
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setJavaClientGeneratorConfiguration(
            JavaClientGeneratorConfiguration javaClientGeneratorConfiguration) {
        this.javaClientGeneratorConfiguration = javaClientGeneratorConfiguration;
    }
    @Override
    public void setJavaModelGeneratorConfiguration(
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration) {
        this.javaModelGeneratorConfiguration = javaModelGeneratorConfiguration;
    }
    @Override
    public void setJavaTypeResolverConfiguration(
            JavaTypeResolverConfiguration javaTypeResolverConfiguration) {
        this.javaTypeResolverConfiguration = javaTypeResolverConfiguration;
    }
    @Override
    public void setJdbcConnectionConfiguration(
            JDBCConnectionConfiguration jdbcConnectionConfiguration) {
        this.jdbcConnectionConfiguration = jdbcConnectionConfiguration;
    }
    @Override
    public void setSqlMapGeneratorConfiguration(
            SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration) {
        this.sqlMapGeneratorConfiguration = sqlMapGeneratorConfiguration;
    }
    @Override
    public ModelType getDefaultModelType() {
        return defaultModelType;
    }

    /**
     * Builds an XmlElement representation of this context. Note that the XML
     * may not necessarily validate if the context is invalid. Call the
     * <code>validate</code> method to check validity of this context.
     *
     * @return the XML representation of this context
     */
    @Override
    public XmlElement toXmlElement() {
        XmlElement xmlElement = new XmlElement("context"); //$NON-NLS-1$

        xmlElement.addAttribute(new Attribute("id", id)); //$NON-NLS-1$

        if (defaultModelType != ModelType.CONDITIONAL) {
            xmlElement.addAttribute(new Attribute(
                    "defaultModelType", defaultModelType.getModelType())); //$NON-NLS-1$
        }

        if (stringHasValue(introspectedColumnImpl)) {
            xmlElement.addAttribute(new Attribute(
                    "introspectedColumnImpl", introspectedColumnImpl)); //$NON-NLS-1$
        }

        if (stringHasValue(targetRuntime)) {
            xmlElement.addAttribute(new Attribute(
                    "targetRuntime", targetRuntime)); //$NON-NLS-1$
        }

        addPropertyXmlElements(xmlElement);

        for (PluginConfiguration pluginConfiguration : pluginConfigurations) {
            xmlElement.addElement(pluginConfiguration.toXmlElement());
        }

        if (commentGeneratorConfiguration != null) {
            xmlElement.addElement(commentGeneratorConfiguration.toXmlElement());
        }

        if (jdbcConnectionConfiguration != null) {
            xmlElement.addElement(jdbcConnectionConfiguration.toXmlElement());
        }

        if (javaTypeResolverConfiguration != null) {
            xmlElement.addElement(javaTypeResolverConfiguration.toXmlElement());
        }

        if (javaModelGeneratorConfiguration != null) {
            xmlElement.addElement(javaModelGeneratorConfiguration
                    .toXmlElement());
        }

        if (sqlMapGeneratorConfiguration != null) {
            xmlElement.addElement(sqlMapGeneratorConfiguration.toXmlElement());
        }

        if (javaClientGeneratorConfiguration != null) {
            xmlElement.addElement(javaClientGeneratorConfiguration.toXmlElement());
        }

        for (MyTableConfiguration tableConfiguration : tableConfigurations) {
            xmlElement.addElement(tableConfiguration.toXmlElement());
        }

        return xmlElement;
    }
    //todo
//    @Override
//    public List<Configuration> getTableConfigurations() {
//        return (List<Configuration>)tableConfigurations;
//    }
    @Override
    public String getBeginningDelimiter() {
        return beginningDelimiter;
    }
    @Override
    public String getEndingDelimiter() {
        return endingDelimiter;
    }

    @Override
    public void addProperty(String name, String value) {
        super.addProperty(name, value);

        if (PropertyRegistry.CONTEXT_BEGINNING_DELIMITER.equals(name)) {
            beginningDelimiter = value;
        } else if (PropertyRegistry.CONTEXT_ENDING_DELIMITER.equals(name)) {
            endingDelimiter = value;
        } else if (PropertyRegistry.CONTEXT_AUTO_DELIMIT_KEYWORDS.equals(name)) {
            if (stringHasValue(value)) {
                autoDelimitKeywords = new Boolean(isTrue(value));
            }
        }
    }
    @Override
    public CommentGenerator getCommentGenerator() {
        if (commentGenerator == null) {
            commentGenerator = MyObjectFactory.createCommentGenerator(this);
        }

        return commentGenerator;
    }
    @Override
    public JavaFormatter getJavaFormatter() {
        if (javaFormatter == null) {
            javaFormatter = MyObjectFactory.createJavaFormatter(this);
        }

        return javaFormatter;
    }
    @Override
    public XmlFormatter getXmlFormatter() {
        if (xmlFormatter == null) {
            xmlFormatter = MyObjectFactory.createXmlFormatter(this);
        }

        return xmlFormatter;
    }
    @Override
    public CommentGeneratorConfiguration getCommentGeneratorConfiguration() {
        return commentGeneratorConfiguration;
    }
    @Override
    public void setCommentGeneratorConfiguration(
            CommentGeneratorConfiguration commentGeneratorConfiguration) {
        this.commentGeneratorConfiguration = commentGeneratorConfiguration;
    }
    @Override
    public Plugin getPlugins() {
        return pluginAggregator;
    }
    @Override
    public String getTargetRuntime() {
        return targetRuntime;
    }
    @Override
    public void setTargetRuntime(String targetRuntime) {
        this.targetRuntime = targetRuntime;
    }
    @Override
    public String getIntrospectedColumnImpl() {
        return introspectedColumnImpl;
    }
    @Override
    public void setIntrospectedColumnImpl(String introspectedColumnImpl) {
        this.introspectedColumnImpl = introspectedColumnImpl;
    }

    // methods related to code generation.
    //
    // Methods should be called in this order:
    //
    // 1. getIntrospectionSteps()
    // 2. introspectTables()
    // 3. getGenerationSteps()
    // 4. generateFiles()
    //

    private List<IntrospectedTable> introspectedTables;
    @Override
    public int getIntrospectionSteps() {
        int steps = 0;

        steps++; // connect to database

        // for each table:
        //
        // 1. Create introspected table implementation

        steps += tableConfigurations.size() * 1;

        return steps;
    }

    /**
     * Introspect tables based on the configuration specified in the
     * constructor. This method is long running.
     *
     * @param callback
     *            a progress callback if progress information is desired, or
     *            <code>null</code>
     * @param warnings
     *            any warning generated from this method will be added to the
     *            List. Warnings are always Strings.
     * @param fullyQualifiedTableNames
     *            a set of table names to generate. The elements of the set must
     *            be Strings that exactly match what's specified in the
     *            configuration. For example, if table name = "foo" and schema =
     *            "bar", then the fully qualified table name is "foo.bar". If
     *            the Set is null or empty, then all tables in the configuration
     *            will be used for code generation.
     *
     * @throws SQLException
     *             if some error arises while introspecting the specified
     *             database tables.
     * @throws InterruptedException
     *             if the progress callback reports a cancel
     */
    @Override
    public void introspectTables(ProgressCallback callback,
            List<String> warnings, Set<String> fullyQualifiedTableNames)
            throws SQLException, InterruptedException {

        introspectedTables = new ArrayList<IntrospectedTable>();
        JavaTypeResolver javaTypeResolver = MyObjectFactory
                .createJavaTypeResolver(this, warnings);

        Connection connection = null;

        try {
            callback.startTask(getString("Progress.0")); //$NON-NLS-1$
            connection = getConnection();

            MyDatabaseIntrospector databaseIntrospector = new MyDatabaseIntrospector(
                    this, connection.getMetaData(), javaTypeResolver, warnings);

            for (MyTableConfiguration tc : tableConfigurations) {
                String tableName = composeFullyQualifiedTableName(tc.getCatalog(), tc
                        .getSchema(), tc.getTableName(), '.');

                if (fullyQualifiedTableNames != null
                        && fullyQualifiedTableNames.size() > 0) {
                    if (!fullyQualifiedTableNames.contains(tableName)) {
                        continue;
                    }
                }

                if (!tc.areAnyStatementsEnabled()) {
                    warnings.add(getString("Warning.0", tableName)); //$NON-NLS-1$
                    continue;
                }

                callback.startTask(getString("Progress.1", tableName)); //$NON-NLS-1$
                List<IntrospectedTable> tables = databaseIntrospector
                        .introspectTables(tc);

                if (tables != null) {
                    introspectedTables.addAll(tables);
                }

                callback.checkCancel();
            }
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public int getGenerationSteps() {
        int steps = 0;

        if (introspectedTables != null) {
            for (IntrospectedTable introspectedTable : introspectedTables) {
                steps += introspectedTable.getGenerationSteps();
            }
        }

        return steps;
    }
    @Override
    public void generateFiles(ProgressCallback callback,
            List<GeneratedJavaFile> generatedJavaFiles,
            List<GeneratedXmlFile> generatedXmlFiles, List<String> warnings)
            throws InterruptedException {

        pluginAggregator = new PluginAggregator();
        for (PluginConfiguration pluginConfiguration : pluginConfigurations) {
            Plugin plugin = MyObjectFactory.createPlugin(this,
                    pluginConfiguration);
            if (plugin.validate(warnings)) {
                pluginAggregator.addPlugin(plugin);
            } else {
                warnings.add(getString("Warning.24", //$NON-NLS-1$
                        pluginConfiguration.getConfigurationType(), id));
            }
        }

        if (introspectedTables != null) {
            for (IntrospectedTable introspectedTable : introspectedTables) {
                callback.checkCancel();

                introspectedTable.initialize();
                introspectedTable.calculateGenerators(warnings, callback);
                //生成接口
                generatedJavaFiles.addAll(introspectedTable
                        .getGeneratedJavaFiles());
                //生成xml
                generatedXmlFiles.addAll(introspectedTable
                        .getGeneratedXmlFiles());

                generatedJavaFiles.addAll(pluginAggregator
                        .contextGenerateAdditionalJavaFiles(introspectedTable));
                generatedXmlFiles.addAll(pluginAggregator
                        .contextGenerateAdditionalXmlFiles(introspectedTable));
            }
        }

        generatedJavaFiles.addAll(pluginAggregator
                .contextGenerateAdditionalJavaFiles());
        generatedXmlFiles.addAll(pluginAggregator
                .contextGenerateAdditionalXmlFiles());
    }

    private Connection getConnection() throws SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection(
                jdbcConnectionConfiguration);

        return connection;
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // ignore
                ;
            }
        }
    }
    @Override
    public boolean autoDelimitKeywords() {
        return autoDelimitKeywords != null
                && autoDelimitKeywords.booleanValue();
    }
}
