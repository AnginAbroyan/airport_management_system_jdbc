package org.example;

import org.example.service.PassengerService;
import org.example.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private static final String url  = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String username  = "postgres";
    private static final String password  = "Klaus67phobia26!";

    public static void main(String[] args ) {

        ConnectionUtil db = new ConnectionUtil();
        Connection conn = db.connectDB();
//        db.createTableCompany(conn);
//        db.createTablePassenger(conn);
//        db.createTableTrip(conn);
//        db.createTablePassInTrip(conn);


        PassengerService passengerService = new PassengerService();
        passengerService.getById(5);



    }
}