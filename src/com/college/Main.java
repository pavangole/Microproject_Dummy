package com.college;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        System.out.println("This is Pavan Gole");
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Database Password :- ");
        String password = in.next();

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected! ");
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from triangle");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            connection.close();
        }
        catch(Exception e){ System.out.println(e.getStackTrace());}
    }

}