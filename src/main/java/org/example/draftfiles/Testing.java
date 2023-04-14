package org.example.draftfiles;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testing {
    private static final String url = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String user = "postgres";
    private static final String password = "Klaus67phobia26!";

    /**
     * This method connects to our database from PostgreSQL.
     *
     * @return whether connection established or not, if not and there is an exception, the exception
     * will be caught.
     */
    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


//    File file = new File("C:\\Users\\Serge\\Desktop\\homework_JDBC\\companies.txt");
//        copy dept from '/opt/PostgreSQL/9.3/data/new.txt' with delimiter ',';
//
//        create table companies(company_name, found_date);

    public void createTableCompany(Connection conn) throws IOException {
        Statement stmt;
        try {
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn("copy company(company_name, found_date) from STDIN (FORMAT CSV, HEADER, DELIMITER ',');",
                            new BufferedReader(new FileReader("C:/Users/Serge/Desktop/homework_JDBC/companies.txt"))
                    );
            String query = "CREATE TABLE company (company_name VARCHAR(40) NOT NULL, found_date DATE NOT NULL); copy company(company_name, found_date) from 'C:\\Users\\Serge\\Desktop\\homework_JDBC\\companies.txt'  with (FORMAT CSV, HEADER, DELIMITER ',');";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
//            String query1 = "copy company(company_name, found_date) from 'C:/Users/Serge/Desktop/homework_JDBC/companies.txt'  delimiter ','  CSV HEADER;";
//            stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//            System.out.println("Rows inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //try (Connection conn = DriverManager.getConnection(connUrl, myUid, myPwd)) {
    //    long rowsInserted = new CopyManager((BaseConnection) conn)
    //            .copyIn(
    //                "COPY table1 FROM STDIN (FORMAT csv, HEADER)",
    //                new BufferedReader(new FileReader("C:/Users/gord/Desktop/testdata.csv"))
    //                );
    //    System.out.printf("%d row(s) inserted%n", rowsInserted);
    //}

//    public void insertRowCompanies(Connection conn) {
//        Statement stmt;
//        try{
//        File file = new File("C:\\Users\\Serge\\Desktop\\homework_JDBC\\companies.txt");
//        FileReader filereader = new FileReader(file);
//        BufferedReader bufferedreader = new BufferedReader(filereader);
//        String line = bufferedreader.readLine();
//        String query = "copy COMPANY from 'C:/Users/Serge/Desktop/homework_JDBC/companies.txt' with delimiter ',';";
//        stmt = conn.createStatement();
//        stmt.executeUpdate(query);
//            System.out.println("Row inserted");
//        }
//        catch(IOException e){
//
//        }
//    }



    //public static void readFromCompanyTxt() {
    //
    //        try {
    //            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    //            File file = new File("C:/Users/asus/Desktop/homework_JDBC/companies.txt");
    //            FileReader fr = new FileReader(file);
    //            BufferedReader reader = new BufferedReader(fr);
    //            String line = reader.readLine();
    //            while (line != null) {
    //                    String[] dateList = line.split(",");
    //                    String a1 = dateList[0];
    //                    String a2 = dateList[1];
    //                    String sql = "INSERT INTO company (company_name, founding_date) VALUES(?,?)";
    //                    PreparedStatement pst = connection.prepareStatement(sql);
    //                    pst.setString(1, a1);
    //                    pst.setString(2, a2);
    //                line = reader.readLine();
    ////                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    //                pst.executeUpdate();
    //                }
    //        } catch (Exception e) {
    //            e.getMessage();


    //------------------------
    //try (Connection conn = DriverManager.getConnection(connUrl, myUid, myPwd)) {
    //    long rowsInserted = new CopyManager((BaseConnection) conn)
    //            .copyIn(
    //                "COPY table1 FROM STDIN (FORMAT csv, HEADER)",
    //                new BufferedReader(new FileReader("C:/Users/gord/Desktop/testdata.csv"))
    //                );
    //    System.out.printf("%d row(s) inserted%n", rowsInserted);
    //}

//    public void insertRowCompanies(Connection conn) {
//        Statement stmt;
//        try{
//        File file = new File("C:\\Users\\Serge\\Desktop\\homework_JDBC\\companies.txt");
//        FileReader filereader = new FileReader(file);
//        BufferedReader bufferedreader = new BufferedReader(filereader);
//        String line = bufferedreader.readLine();
//        String query = "copy COMPANY from 'C:/Users/Serge/Desktop/homework_JDBC/companies.txt' with delimiter ',';";
//        stmt = conn.createStatement();
//        stmt.executeUpdate(query);
//            System.out.println("Row inserted");
//        }
//        catch(IOException e){
//
//        }
//    }



    //public static void readFromCompanyTxt() {
    //
    //        try {
    //            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    //            File file = new File("C:/Users/asus/Desktop/homework_JDBC/companies.txt");
    //            FileReader fr = new FileReader(file);
    //            BufferedReader reader = new BufferedReader(fr);
    //            String line = reader.readLine();
    //            while (line != null) {
    //                    String[] dateList = line.split(",");
    //                    String a1 = dateList[0];
    //                    String a2 = dateList[1];
    //                    String sql = "INSERT INTO company (company_name, founding_date) VALUES(?,?)";
    //                    PreparedStatement pst = connection.prepareStatement(sql);
    //                    pst.setString(1, a1);
    //                    pst.setString(2, a2);
    //                line = reader.readLine();
    ////                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    //                pst.executeUpdate();
    //                }
    //        } catch (Exception e) {
    //            e.getMessage();






}

