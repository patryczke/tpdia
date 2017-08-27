package pl.polsl.tpdia;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Runner {

    public static void main(String args[]) throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("INFO: " + df.format(new Date()) + "TPDIA started...");

        String inputFileName = "C:\\Users\\patry\\Desktop\\Dane dostawy.csv"; //take from arg parameter

        /*
        * prepare db
        * load and validate file
        * execute operations (group by etc)
        * print results
        * */

        Service service = new Service();
        service.initializeApplication();
        service.testConnection();
        service.loadFileData(inputFileName);
        service.testConnection();

        System.out.println("INFO: " + df.format(new Date()) + "TPDIA finished!");
    }


}
