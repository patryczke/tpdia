package pl.polsl.tpdia;

import org.h2.tools.DeleteDbFiles;

import java.lang.reflect.Field;
import java.sql.*;

public class DAO {

    private static DAO instance = null;
    private static Connection connection = null;
    private static Config config = null;
    private DAO() {
    }

    public static DAO getInstance() {
        if(instance == null) {
            config = Config.createDefaultConfig();
            connection = getDBConnection(config);
            instance = new DAO();
        }
        return instance;
    }

    public void initializeDatabase() {

        DeleteDbFiles.execute("~", config.getTableName(), true);

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();

            stmt.execute("DROP TABLE " + config.getTableName());

            StringBuilder initQuery = new StringBuilder();
            initQuery.append("CREATE TABLE " + config.getTableName() + "( ");
            boolean firstRow = true;
            for(RecordAttributes recAttr : RecordAttributes.values()) {
                if(!firstRow) {
                    initQuery.append(", ");
                } else {
                    firstRow = false;
                }
                initQuery.append(recAttr.getName() + " " + recAttr.getType());
            }
            initQuery.append(" )");
            stmt.execute(initQuery.toString());

            connection.commit();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        } finally {
            freeResources(rs, stmt);
        }
    }

    public void storeSingleRow(RecordData record) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO " + config.getTableName() + " ( ");
            query.append(RecordAttributes.STATION.getName() + ",");
            query.append(RecordAttributes.TANK.getName() + ",");
            query.append(RecordAttributes.TYPE.getName() + ",");
            query.append(RecordAttributes.CAPACITY.getName() + ",");
            query.append(RecordAttributes.START_TIME.getName() + ",");
            query.append(RecordAttributes.END_TIME.getName() + ",");
            query.append(RecordAttributes.TRUCK.getName() + ",");
            query.append(RecordAttributes.DRIVER.getName() + ",");
            query.append(RecordAttributes.TERMINAL.getName() + ",");
            query.append(RecordAttributes.DETECTED.getName() + ",");
            query.append(RecordAttributes.DETECTED_NET.getName() + ",");
            query.append(RecordAttributes.DECLARED.getName() + ",");
            query.append(RecordAttributes.DECLARED_NET.getName() + ",");
            query.append(RecordAttributes.START_HEIGHT_PROC.getName() + ",");
            query.append(RecordAttributes.END_HEIGHT_PROC.getName());
            query.append(" ) VALUES ( ");
            query.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            query.append(" )");
            pstmt = connection.prepareStatement(query.toString());
            int i = 0;
            pstmt.setInt(++i, record.getStation());
            pstmt.setInt(++i, record.getTank());
            pstmt.setString(++i, record.getType());
            pstmt.setLong(++i, record.getCapacity());
            pstmt.setDate(++i, new java.sql.Date(record.getStartTime().getTime()));
            pstmt.setDate(++i, new java.sql.Date(record.getEndTime().getTime()));
            pstmt.setInt(++i, record.getTruck());
            pstmt.setInt(++i, record.getDriver());
            pstmt.setInt(++i, record.getTerminal());
            pstmt.setLong(++i, record.getDetected());
            pstmt.setLong(++i, record.getDetectedNet());
            pstmt.setLong(++i, record.getDeclared());
            pstmt.setLong(++i, record.getDeclaredNet());
            pstmt.setInt(++i, record.getStartHeightProc());
            pstmt.setInt(++i, record.getEndHeightProc());
            pstmt.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        } finally {
            freeResources(rs, pstmt);
        }

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

            rs = stmt.executeQuery("select count(*) as TESTOWE from TPDIA");
            if(rs.next()) {
                System.out.println("count=" + rs.getString("TESTOWE"));
            }

        } catch(SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
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
