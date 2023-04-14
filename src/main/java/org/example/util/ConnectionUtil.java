package org.example.util;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.*;
import java.sql.*;

public class ConnectionUtil {
    private static final String url = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String user = "postgres";
    private static final String password = "Klaus67phobia26!";

    /**
     * This method connects to our database from PostgreSQL.
     *
     * @return whether connection established or not, if not and there is an exception, the exception
     * will be caught.
     */
    public Connection connectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Creates table Company with rows that are inserted from companies.txt file
     * @param conn connects to the database in postgresql
     */
    public void createTableCompany(Connection conn) {
        Statement stmt;
        try {
            String query = "CREATE TABLE company (company_id serial PRIMARY KEY, company_name VARCHAR(40) NOT NULL, found_date DATE NOT NULL);";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn("copy company(company_name, found_date) from STDIN (FORMAT CSV, HEADER, DELIMITER ',');",
                            new BufferedReader(new FileReader("C:/Users/Serge/Desktop/homework_JDBC/companies.txt"))
                    );
            System.out.println("Rows inserted");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates table Passenger with rows that are inserted from companies.txt file
     * @param conn connects to the database in postgresql
     */
    public void createTablePassenger(Connection conn){
        Statement stmt;
        try {
            String query = "CREATE TABLE passenger (passenger_id serial PRIMARY KEY, passenger_name VARCHAR(40) NOT NULL, pass_phone VARCHAR(40) NOT NULL, " +
                    "pass_country VARCHAR(40) NOT NULL, pass_city VARCHAR(40) NOT NULL);";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn("copy passenger(passenger_name, pass_phone, pass_country, pass_city) from STDIN (FORMAT CSV, HEADER, DELIMITER ',');",
                            new BufferedReader(new FileReader("C:/Users/Serge/Desktop/homework_JDBC/passengers.txt"))
                    );
            System.out.println("Rows inserted");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates table Trip with rows that are inserted from companies.txt file
     * @param conn connects to the database in postgresql
     */
    public void createTableTrip(Connection conn){
        Statement stmt;
        try {
            String query = "CREATE TABLE trip (trip_number INTEGER PRIMARY KEY, company_id INTEGER references company(company_id) NOT NULL, " +
                    "trip_organizer VARCHAR(40) NOT NULL, departure_city VARCHAR(40) NOT NULL, " +
                    "destination_city VARCHAR(40) NOT NULL, time_departure timestamp NOT NULL, " +
                    "time_arrival timestamp NOT NULL);";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn("copy trip(trip_number, company_id, trip_organizer, departure_city, destination_city, time_departure, time_arrival) from STDIN (FORMAT CSV, HEADER, DELIMITER ',');",
                            new BufferedReader(new FileReader("C:/Users/Serge/Desktop/homework_JDBC/trip.txt"))
                    );
            System.out.println("Rows inserted");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates table Passenger in Trip with rows that are inserted from companies.txt file
     * @param conn connects to the database in postgresql
     */
    public void createTablePassInTrip(Connection conn){
        Statement stmt;
        try {
            String query = "CREATE TABLE pass_in_trip (trip_id INTEGER references trip(trip_number) not null, psg_id INTEGER references passenger(passenger_id) NOT NULL, " +
                    "trip_date timestamp NOT NULL, trip_place VARCHAR(40) NOT NULL);";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn("copy pass_in_trip(trip_id, psg_id, trip_date, trip_place) from STDIN (FORMAT CSV, HEADER, DELIMITER ',');",
                            new BufferedReader(new FileReader("C:/Users/Serge/Desktop/homework_JDBC/pass_in_trip.txt"))
                    );
            System.out.println("Rows inserted");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

