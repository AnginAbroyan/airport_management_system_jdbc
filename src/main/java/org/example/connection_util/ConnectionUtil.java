package org.example.connection_util;

import java.sql.*;

public class ConnectionUtil {
    private static Connection conn = null;

    static {
          final String url = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
          final String user = "postgres";
          final String password = "Klaus67phobia26!";
        try {

            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * This method connects the project to the database from PostgreSQL.
     * @return whether connection established or not, if not and there is an exception, the exception
     * will be caught and wrapped.
     */

    public static Connection connectDB()
    {
        return conn;
    }

}

