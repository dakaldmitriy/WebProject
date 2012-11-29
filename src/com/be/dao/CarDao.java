package com.be.dao;


import com.be.beans.Car;
import com.be.jdbc.JDBCConnection;
import com.be.util.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDao {
    
    private Connection conn;
    private Logger logger; 
    
      public CarDao() {
        conn = JDBCConnection.getInstance().getConection();
        logger = new Logger();
    }

    public void addCar(String type, String producer, String model, String description, boolean deleted) {
        String statement = Statements.ADD_CAR.getStatementValue();
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setInt(1, this.GenerateId(type, producer, model, description));
            stmt.setString(2, type);
            stmt.setString(3, producer);
            stmt.setString(4, model);
            stmt.setString(5, description);
            stmt.setBoolean(6, deleted);
            stmt.executeUpdate();
            conn.commit();
            logger.addLog("INFO", "executed");
         } catch (SQLException ex) {

            logger.addLog("ERROR", ex.getLocalizedMessage());
            
        }
        
        logger.addLog("INFO", statement+" executed");
    }

    private int GenerateId(String type, String producer, String model, String description) {
        return type.hashCode()+producer.hashCode()+model.hashCode()+description.hashCode();
    }

    public Car getCar(int carId) {
        String statement = Statements.FIND_CAR_BY_ID.getStatementValue();
        Car car = new Car();
        try {
            PreparedStatement stmt = conn.prepareStatement(statement);
            ResultSet rs = stmt.executeQuery();
            car.setCarId(rs.getInt("carId"));
            car.setDeleted(rs.getBoolean("delted"));
            car.setDescription(rs.getString("description"));
            car.setModel(rs.getString("model"));
            car.setProducer(rs.getString("producer"));
            car.setType(rs.getString("type"));

        } catch (SQLException  ex) {
            logger.addLog("ERROR", ex.getLocalizedMessage());
        }
        logger.addLog("INFO", statement+" executed");
        return car;
    }
    
    public void updateCar(int carId, String type, String producer, String model, String description, boolean deleted){
        String statement= Statements.UPDATE_CAR.getStatementValue();
        try{
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setInt(5, carId);
            stmt.setString(1, type);
            stmt.setString(2, producer);
            stmt.setString(3, model);
            stmt.setString(4, description);
            stmt.executeUpdate();
         
        }catch(SQLException ex){
            logger.addLog("ERROR", ex.getLocalizedMessage());
        }
        logger.addLog("INFO", statement+" executed");
       
    }
}
