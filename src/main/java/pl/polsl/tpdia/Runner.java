package pl.polsl.tpdia;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Runner {

    public static void main(String args[]) throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("INFO: " + df.format(new Date()) + ", TPDIA started...");

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

        int limit = 3;

        service.findDiff(RecordAttributes.STATION.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.STATION.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.STATION.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.TANK.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.TANK.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.TANK.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.TYPE.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.TYPE.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.TYPE.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.CAPACITY.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.CAPACITY.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.CAPACITY.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.TRUCK.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.TRUCK.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.TRUCK.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.DRIVER.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.DRIVER.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.DRIVER.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);
        service.findDiff(RecordAttributes.TERMINAL.getName(), RecordAttributes.DECLARED.getName(), RecordAttributes.DETECTED.getName(), limit);
        service.findDiff(RecordAttributes.TERMINAL.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), limit);
        service.findDiff(RecordAttributes.TERMINAL.getName(), RecordAttributes.DECLARED_NET.getName(), RecordAttributes.DETECTED_NET.getName(), RecordAttributes.CAPACITY.getName(), limit);

        System.out.println("INFO: " + df.format(new Date()) + ", TPDIA finished!");
    }


}
