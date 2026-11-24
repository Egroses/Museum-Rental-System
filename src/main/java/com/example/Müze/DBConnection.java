package com.example.yenijavadeneme;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection connection=null;
    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/rezerve";
            connection= DriverManager.getConnection(url,"root","");
            System.out.println("Connected");

        } catch (Exception e) {
        }

        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
