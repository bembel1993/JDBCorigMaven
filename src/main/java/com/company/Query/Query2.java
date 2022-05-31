package com.company.Query;

import com.company.Connection.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Query2 {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        try {

            // Open a connection
            JDBC.connect();

            // Execute a query
            stmt = JDBC.connection.createStatement();
            String publishersName;
            // Create new author
            BufferedReader enterName = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter publisher: ");
            publishersName = enterName.readLine();

            //  String query = "SELECT * FROM authors ORDER BY lastName , firstName ";
            String sql = "INSERT INTO publishers(publisherName) VALUES (?)";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, publishersName);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Added %d object", rows);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

        String query2Author = "SELECT * FROM publishers";


        System.out.println("Show all publishers");

        ResultSet rs1 = stmt.executeQuery(query2Author);

        while (rs1.next()) {
            int id = rs1.getInt("publisherID");
            String pubName = rs1.getString("publisherName");
            System.out.println(id + "\t" + pubName);
        }

    }

    {
        //finally block used to close resources
        JDBC.close();
    }
}