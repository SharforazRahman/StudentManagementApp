package com.studentApplication.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String userName = "root";
            String password = "swaR4877";
            String url = "jdbc:mysql://localhost:3306/student?autoReconnect = true&&useSSL=false";

            con = DriverManager.getConnection(url,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
