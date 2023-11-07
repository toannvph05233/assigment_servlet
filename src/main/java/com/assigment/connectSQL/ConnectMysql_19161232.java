package com.assigment.connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysql_19161232 {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/assigment", "root",
                    "12345678");
        } catch (Exception e) {
            System.out.print("Ket noi that bai voi csdl");
            System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
            e.printStackTrace();
        }
        return null;
    }
}