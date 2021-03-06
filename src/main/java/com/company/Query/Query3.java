package com.company.Query;


import com.company.Connection.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Query3 {
   
   public static void main(String[] args) throws SQLException {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
          
          String query3_name = "SELECT publisherID, publisherName FROM publishers WHERE publisherID=3";
          
          ResultSet rs1 = stmt.executeQuery(query3_name);
          String name = null;
          while(rs1.next()){
              int id = rs1.getInt("publisherID");
              name = rs1.getString("publisherName");
          }
          
          System.out.println();
          System.out.println("--------------------------------------------------");
          System.out.println("List of books by the publisher " + name + ":");
          System.out.println("--------------------------------------------------");
              
           ///////////////////////////////////////////////
           // Execute a query
           String publishersName;
           // Create
           //  String query = "SELECT * FROM authors ORDER BY lastName , firstName ";
           stmt = JDBC.connection.createStatement();
           int rows = stmt.executeUpdate("INSERT titles(title, editionNumber, year, publisherID, price)" +
                   "VALUES ('Siegeslied von Nibelungen - -', 5, 2005, 5, 1000)");

           System.out.printf("Added %d object\n", rows);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       String query3_books = "SELECT isbn, title, year, publisherID FROM titles WHERE publisherID=3 ORDER BY title";
//////////////////////////////////////////////////////
	      ResultSet rs2 = stmt.executeQuery(query3_books);
           
          while(rs2.next()){
                  int id = rs2.getInt("publisherID");
                  String isbn = rs2.getString("isbn");
                  String title = rs2.getString("title");
                  String year = rs2.getString("year");
                  System.out.println(id + " - " + title + " - " + year + " - " + isbn);
          }
          System.out.println("--------------------------------------------------");
          System.out.println();

       {
           //finally block used to close resources
           JDBC.close();
       }
	}
}