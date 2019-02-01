package com.javapractice.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJavaDb {
    Connection conn;

    public void connection() throws SQLException {
        // -------------------------------------------
        // URL format is
        // jdbc:derby:<local directory to save data>
        // -------------------------------------------
        String dbUrl = "jdbc:derby:demoDB;create=true";
        conn = DriverManager.getConnection(dbUrl);
    }

    public void initialize() throws SQLException {
        Statement stmt = conn.createStatement();

        // drop table
        stmt.executeUpdate("Drop Table rentalfees");

        // create table
        stmt.executeUpdate("Create table rentalfees (name varchar(30) primary key, value int)");

        // insert 2 rows
        stmt.executeUpdate("insert into rentalfees values ('bike.hour'  , 5)");
        stmt.executeUpdate("insert into rentalfees values ('bike.day'   , 20)");
        stmt.executeUpdate("insert into rentalfees values ('bike.week'  ,60)");
        stmt.executeUpdate("insert into rentalfees values ('car.hour'   ,20)");
        stmt.executeUpdate("insert into rentalfees values ('car.day'    ,80)");
        stmt.executeUpdate("insert into rentalfees values ('car.week'   ,300)");

        // query
        ResultSet rs = stmt.executeQuery("SELECT * FROM rentalfees");

        // print out query result
        while (rs.next()) {
            System.out.printf("%s\t%d\n", rs.getString("name"), rs.getInt("value"));
        }
    }

    public static void main(String[] args) throws SQLException {
        HelloJavaDb app = new HelloJavaDb();

        app.connection();
        app.initialize();
    }

}