package com.company.Query;

import com.company.Connection.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Query1 {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        try {

            // Open a connection
            JDBC.connect();

            // Execute a query
            stmt = JDBC.connection.createStatement();

            /*
             * Creates the query to alphabatize all rows from authors by their first and last name
             *
             * SELECT *
             * FROM authors
             * ORDER BY firstName, lastName
             */

            String firstName;
            String lastName;

            BufferedReader enterRussWord = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter First Name: ");
            firstName = enterRussWord.readLine();

            BufferedReader enterEngWord = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Last Name: ");
            lastName = enterEngWord.readLine();

            //  String query = "SELECT * FROM authors ORDER BY lastName , firstName ";
            String sql = "INSERT INTO authors(firstName, lastName) VALUES (?, ?)";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Added %d object", rows);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Alphabatized all rows by first and last name:");

        ResultSet rs1 = stmt.executeQuery("SELECT * FROM authors");


        while (rs1.next()) {
            //		  int id = rs1.getInt("authorID");
            String firstName = rs1.getString("firstName");
            String lastName = rs1.getString("lastName");
            System.out.println("\t" + firstName + "\t\t" + lastName);
        }
//finally block used to close resources
        JDBC.close();
    }
}