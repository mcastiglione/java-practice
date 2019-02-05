package com.javapractice.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private Connection conn;

    public CreateTable() {

    }

    public void init() throws SQLException {
        this.connection();
        this.initialize();
        conn.close();
    }

    public void connection() throws SQLException {
        // -------------------------------------------
        // URL format is
        // jdbc:derby:<local directory to save data>
        // -------------------------------------------
        String dbUrl = "jdbc:derby:demoDB;create=true";
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        conn = DriverManager.getConnection(dbUrl);
    }

    public void initialize() throws SQLException {
        Statement stmt = conn.createStatement();
        // create table
        stmt.executeUpdate("Create table rentalfees (name varchar(30) primary key, value int)");
    }

    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        try {
            createTable.init();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
