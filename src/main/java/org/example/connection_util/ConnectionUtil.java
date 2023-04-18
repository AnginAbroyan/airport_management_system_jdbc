package org.example.connection_util;

import java.sql.*;

public class ConnectionUtil {
    private static Connection conn;
    private static ConnectionUtil connectionUtil;

    private static final String URL = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Klaus67phobia26!";

    public ConnectionUtil() {
    }

    public static ConnectionUtil getInstance() {
        if (connectionUtil==null)
        {
            connectionUtil = new ConnectionUtil();
        }
        return connectionUtil;
    }



    /**
     * This method connects the project to the database from PostgreSQL.
     * @return whether connection established or not, if not and there is an exception, the exception
     * will be caught and wrapped.
     */

    public static Connection connectDB()
    {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

