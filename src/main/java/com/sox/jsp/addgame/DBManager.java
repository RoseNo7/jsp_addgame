package com.sox.jsp.addgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    static DBManager dbManager;

    /* 버전 8.0 이상 : "com.mysql.cj.jdbc.Driver" 사용
       버전 8.0 미만 : "com.mysql.jdbc.Driver" 사용     */
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost/game?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
    final String USERNAME = "soxuser";
    final String PASSWORD = "sox123";

    static Connection con = null;
    static PreparedStatement pstate = null;
    static ResultSet rs = null;

    private DBManager() {}

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }

        return dbManager;
    }

    // DB 연결
    public void connect() {
        try {
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("db와 연결이 되지않음");
        }
    }

    public static PreparedStatement getPstate() {
        return pstate;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setPstate(PreparedStatement pstate) {
        DBManager.pstate = pstate;
    }

    public static void setRs(ResultSet rs) {
        DBManager.rs = rs;
    }

    public Connection getCon() {
        return con;
    }
}
