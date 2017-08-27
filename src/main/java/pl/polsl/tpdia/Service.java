package pl.polsl.tpdia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Service {

    private DAO dao = null;
    private Config config = null;
    public Service() {
        dao = DAO.getInstance();
        config = Config.createDefaultConfig();
    }

    public void initializeApplication() {
        dao.initializeDatabase();
    }

    public void loadFileData(String inputFileName) {

        long rowCounter = 0;
        BufferedReader reader = null;
        try {
            File file = new File(inputFileName);
            if(!file.exists()) {
                System.err.println("ERROR: not found file: " + inputFileName);
                throw new ApplicationException("Not found input file: " + inputFileName);
            }
            reader = new BufferedReader(new FileReader(file));
            String line;

            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                rowCounter++;
                String[] chunks = line.split(config.getDefaultSeparator());

                if(isFirstLine) {
                    isFirstLine = false;
                    //todo validate column names
                    continue;
                }

                if(chunks.length != RecordAttributes.values().length - 1) {
                    System.out.println("WARN: Skipped row id=" + rowCounter + ", due to invalid chunks");
                    continue;
                }

                RecordData data = null;
                try {
                    data = prepareRecordData(chunks);
                } catch(ApplicationException e) {
                    //skip
                    continue;
                }
                dao.storeSingleRow(data);
            }

        } catch(Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    public void testConnection() {
        dao.test();
    }

    private RecordData prepareRecordData(String[] chunks) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(config.getDefaultRowDateFormat());
        int i = 0;
        RecordData record = new RecordData();
        try {
            record.setStation(new Integer(chunks[i++]));
            record.setTank(new Integer(chunks[i++]));
            record.setType(chunks[i++]);
            record.setCapacity(new Long(chunks[i++]));
            record.setStartTime(dateFormat.parse(chunks[i++]));
            record.setEndTime(dateFormat.parse(chunks[i++]));
            record.setTruck(new Integer(chunks[i++]));
            record.setDriver(new Integer(chunks[i++]));
            record.setTerminal(new Integer(chunks[i++]));
            record.setDetected(new Long(chunks[i++]));
            record.setDetectedNet(new Long(chunks[i++]));
            record.setDeclared(new Long(chunks[i++]));
            record.setDeclaredNet(new Long(chunks[i++]));
            record.setStartHeightProc(new Integer(chunks[i++]));
            record.setEndHeightProc(new Integer(chunks[i++]));
        } catch(Exception e) {
            System.err.println("WARN: " + Arrays.toString(chunks) + ", columnId: " + i + ", " + e.getMessage());
            throw new ApplicationException(e.getMessage(), e);
        }
        return record;
    }

}
