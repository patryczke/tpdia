package pl.polsl.tpdia;

import org.h2.tools.DeleteDbFiles;

import java.sql.*;

public class DAO {

    private static DAO instance = null;
    private static Connection connection = null;
    private DAO() {
    }

    public static DAO getInstance() {
        if(instance == null) {
            connection = getDBConnection(Config.createDefaultConfig());
            instance = new DAO();
        }
        return instance;
    }

    public void initializeDatabase() {

        DeleteDbFiles.execute("~", "TPDIA", true);

    }

    public void test() {

        Statement stmt = null;
        ResultSet rs = null;
        try {

            stmt = connection.createStatement();
            rs = stmt.executeQuery("select CURRENT_DATE as TESTOWE from DUAL where 1=1");
            if(rs.next()) {
                System.out.println(rs.getString("TESTOWE"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            freeResources(rs, stmt);
        }

    }

    private static Connection getDBConnection(Config config) {
        Connection dbConnection = null;
        try {
            Class.forName(config.getDriver());
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        }
        try {
            dbConnection = DriverManager.getConnection(config.getConnectionString(), config.getUsername(), config.getPassword());
            return dbConnection;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    private void freeResources(ResultSet rs, Statement stmt) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch(Exception e) {
            throw new ApplicationException(e.getMessage(), e);
        }
    }

}
