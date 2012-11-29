package com.be.util;

import com.be.dao.Statements;
import com.be.jdbc.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Logger {

    private Connection conn;

    public Logger() {
        conn = JDBCConnection.getInstance().getConection();
    }

    public void addLog(String event, String value) {
        String statement = Statements.ADD_LOG.getStatementValue();
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setInt(1, IdGenerator.LogId());
            stmt.setString(2, event);
            stmt.setString(3, value);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
        } 



    }
}
