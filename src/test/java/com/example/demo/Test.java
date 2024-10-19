package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    private static final String DBURL = "jdbc:sqlserver://122.224.87.50:1433;DataBaseName=AIS20221215160453";
    private static final String DBUSER = "ppy_read";
    private static final String DBPASSWORD = "ppy@read200";
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(1) FROM [dbo].[T_BD_ACCOUNT_L]");
            while(rs.next()){
                System.err.println("----------------------------------");
                System.err.println("查询结果===>>> " + rs.getInt(1));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
