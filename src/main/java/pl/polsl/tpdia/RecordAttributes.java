package pl.polsl.tpdia;


public enum RecordAttributes {

    ID("ID", "BIGINT PRIMARY KEY AUTO_INCREMENT", null),
    STATION("STATION", "INT", "station"),
    TANK("TANK", "INT", "tank"),
    TYPE("TYPE", "VARCHAR(20)", "type"),
    CAPACITY("CAPACITY", "BIGINT", "capacity"),
    START_TIME("START_TIME", "DATETIME", "startTime"),
    END_TIME("END_TIME", "DATETIME", "endTime"),
    TRUCK("TRUCK", "INT", "truck"),
    DRIVER("DRIVER", "INT", "driver"),
    TERMINAL("TERMINAL", "INT", "terminal"),
    DETECTED("DETECTED", "BIGINT", "detected"),
    DETECTED_NET("DETECTED_NET", "BIGINT", "detectedNet"),
    DECLARED("DECLARED", "BIGINT", "declared"),
    DECLARED_NET("DECLARED_NET", "BIGINT", "declaredNet"),
    START_HEIGHT_PROC("START_HEIGHT_PROC", "BIGINT", "startHeightProc"),
    END_HEIGHT_PROC ("END_HEIGHT_PROC", "BIGINT", "endHeightProc");

    private String dbName;
    private String dbType;
    private String mappedDtoField;
    RecordAttributes(String name, String type, String mappedDtoField) {
        dbName = name;
        dbType = type;
        this.mappedDtoField = mappedDtoField;
    }
    public String getName() {
        return dbName;
    }
    public String getType() {
        return dbType;
    }
    public String getMappedDtoField() {
        return mappedDtoField;
    }
}
