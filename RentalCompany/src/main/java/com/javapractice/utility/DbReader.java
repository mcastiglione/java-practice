package com.javapractice.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DbReader {

    private Connection conn;

    private HashMap<String, Integer> data = new HashMap<String,Integer>();

    private DbReader() {
        init();
    }

    private static class DbHolder {
        private static final DbReader INSTANCE = new DbReader();
    }

    public static DbReader getInstance()
    {
        return DbReader.DbHolder.INSTANCE;
    }

    public void init() {
        try {
            this.connection();
            this.load();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void connection() throws SQLException {
        // -------------------------------------------
        // URL format is
        // jdbc:derby:<local directory to save data>
        // -------------------------------------------
        String dbUrl = "jdbc:derby:demoDB;create=true";
        conn = DriverManager.getConnection(dbUrl);
    }

    public void load() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM rentalfees");
        String name;
        Integer value;
        while (rs.next()) {
            name = rs.getString("name");
            value = rs.getInt("value");
            data.put(name,value);
        }
    }

    public Integer getProperty(String name) {
        return data.get(name);
    }
}
