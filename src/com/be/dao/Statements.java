package com.be.dao;


public enum Statements{
    //----Car statements
    FIND_CAR_BY_ID("SELECT * FROM car WHERE car.carId = ? "),
    FIND_CAR_BY_MODEL("SELECT * FROM car WHERE car.model = ? "),
    FIND_CAR_BY_DESCRIPTION("SELECT * FROM car WHERE car.description = ? "),
    FIND_CAR_BY_TYPE("SELECT * FROM car WHERE car.model = ? "),
    DELETE_CAR("DELETE FROM car WHERE car.carId = ? "),
    DELETE_BY_FLAG("UPDATE car SET car.deleted = 'true' WHERE car.carId = ? "),
    UPDATE_CAR("UPDATE car SET car.type = ?, car.producer = ?, car.model = ?, car.description = ? WHERE car.carId = ? "),
    ADD_CAR("INSERT INTO car(carId,type,producer,model,description,deleted) VALUES (?,?,?,?,?,?)"),
    //--Log statements
    ADD_LOG("INSERT INTO logs(logId,event,value) VALUES (?,?,?)");
    
    private String stmnt;
    
    private Statements(String value) {
        stmnt = value;
    }
    
    static public Statements getStatement(String sType){
        for (Statements type: Statements.values()) {
            if (type.getStatementValue().equals(sType)) {
                return type;
            }
        }
        throw new RuntimeException("unknown statement");        
    }
    
    
     public String getStatementValue() {
        return stmnt;
    }
    
    
}
