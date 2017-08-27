package pl.polsl.tpdia;

public class Runner {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static void main(String args[]) throws Exception {

        System.out.println("INFO: TPDIA started...");

        /*
        * prepare db
        * load and validate file
        * execute operations (group by etc)
        * print results
        * */

        Service service = new Service();
        service.initializeApplication();
        service.testConnection();
    }


}
