package pl.polsl.tpdia;

public class Service {

    private DAO dao = null;
    public Service() {
        dao = DAO.getInstance();
    }

    public void initializeApplication() {
        dao.initializeDatabase();
    }

    public void testConnection() {
        dao.test();
    }

}
