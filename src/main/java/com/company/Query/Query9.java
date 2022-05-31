package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query9 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            // Open a connection
            JDBC.connect();

            // Execute a query
            stmt = JDBC.connection.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM AUTHORS WHERE firstName = 'Vova'");
            System.out.printf(" %d row(s) is deleted", rows);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}