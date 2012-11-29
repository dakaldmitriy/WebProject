package com.be.jdbc;

import com.be.util.Props;
import java.sql.Connection;

import java.sql.DriverManager;


import java.sql.SQLException;

public class JDBCConnection {

    private Props props = new Props();

    private JDBCConnection() {
    }

    private static class JDBCConnectionHolder {

        public static final JDBCConnection INSTANCE = new JDBCConnection();
    }

    public static JDBCConnection getInstance() {
        return JDBCConnectionHolder.INSTANCE;
    }

    public Connection getConection() {
        Connection conn = null;
        try {
            Class.forName(props.getProperty("JDBC_DRIVER"));
            conn = DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("USERNAME"),props.getProperty("PASSWORD") );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //TODO add logging
        } catch (SQLException ex ){
            ex.printStackTrace();
        }
        
        if (conn == null) {
            //TODO add log
        }

        return conn;    

    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            
        }
    }
}
