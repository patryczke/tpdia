package pl.polsl.tpdia;


import java.util.Date;

public class RecordData {

    private int station;
    private int tank;
    private String type;
    private long capacity;
    private Date startTime;
    private Date endTime;
    private int truck;
    private int driver;
    private int terminal;
    private long detected;
    private long detectedNet;
    private long declared;
    private long declaredNet;
    private int startHeightProc;
    private int endHeightProc;

    public int getStation() {
        return station;
    }
    public void setStation(int station) {
        this.station = station;
    }

    public int getTank() {
        return tank;
    }
    public void setTank(int tank) {
        this.tank = tank;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public long getCapacity() {
        return capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTruck() {
        return truck;
    }
    public void setTruck(int truck) {
        this.truck = truck;
    }

    public int getDriver() {
        return driver;
    }
    public void setDriver(int driver) {
        this.driver = driver;
    }

    public int getTerminal() {
        return terminal;
    }
    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public long getDetected() {
        return detected;
    }
    public void setDetected(long detected) {
        this.detected = detected;
    }

    public long getDetectedNet() {
        return detectedNet;
    }
    public void setDetectedNet(long detectedNet) {
        this.detectedNet = detectedNet;
    }

    public long getDeclared() {
        return declared;
    }
    public void setDeclared(long declared) {
        this.declared = declared;
    }

    public long getDeclaredNet() {
        return declaredNet;
    }
    public void setDeclaredNet(long declaredNet) {
        this.declaredNet = declaredNet;
    }

    public int getStartHeightProc() {
        return startHeightProc;
    }
    public void setStartHeightProc(int startHeightProc) {
        this.startHeightProc = startHeightProc;
    }

    public int getEndHeightProc() {
        return endHeightProc;
    }
    public void setEndHeightProc(int endHeightProc) {
        this.endHeightProc = endHeightProc;
    }
}
