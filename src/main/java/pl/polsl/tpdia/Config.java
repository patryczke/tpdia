package pl.polsl.tpdia;

public class Config {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private static final String DB_TABLE_NAME = "TPDIA";
    private static final String DEFAULT_SEPARATOR = ";";
    private static final String DEFAULT_ROW_DATE_FORMAT = "dd.MM.yyyy HH:mm";

    private String driver;
    private String connectionString;
    private String username;
    private String password;
    private String tableName;
    private String defaultSeparator;
    private String defaultRowDateFormat;

    private Config() {
    }

    public String getDriver() {
        return driver;
    }
    public String getConnectionString() {
        return connectionString;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getTableName() {
        return tableName;
    }
    public String getDefaultSeparator() {
        return defaultSeparator;
    }
    public String getDefaultRowDateFormat() {
        return defaultRowDateFormat;
    }

    public static Config createDefaultConfig() {
        Config conf = new Config();
        conf.driver = DB_DRIVER;
        conf.connectionString = DB_CONNECTION;
        conf.username = DB_USER;
        conf.password = DB_PASSWORD;
        conf.tableName = DB_TABLE_NAME;
        conf.defaultSeparator = DEFAULT_SEPARATOR;
        conf.defaultRowDateFormat = DEFAULT_ROW_DATE_FORMAT;
        return conf;
    }

}
