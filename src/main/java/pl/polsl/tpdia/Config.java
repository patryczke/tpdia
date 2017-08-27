package pl.polsl.tpdia;

public class Config {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    private String driver;
    private String connectionString;
    private String username;
    private String password;

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

    public static Config createDefaultConfig() {
        Config conf = new Config();
        conf.driver = DB_DRIVER;
        conf.connectionString = DB_CONNECTION;
        conf.username = DB_USER;
        conf.password = DB_PASSWORD;
        return conf;
    }

}
