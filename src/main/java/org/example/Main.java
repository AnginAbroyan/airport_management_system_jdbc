package org.example;

import org.example.models.Passenger;
import org.example.service_imp.PassengerServiceImp;

public class Main {
    private static final String url  = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String username  = "postgres";
    private static final String password  = "Klaus67phobia26!";

    public static void main(String[] args ) {

//        ConnectionUtil db = new ConnectionUtil();
//        Connection conn = db.connectDB();
//        db.createTableCompany(conn);
//        db.createTablePassenger(conn);
//        db.createTableTrip(conn);
//        db.createTablePassInTrip(conn);


        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();
//        passengerServiceImp.getById(5);
//        System.out.println(passengerService.getAll());
//        System.out.println(passengerServiceImp.get(5, 10, "pass_city"));
//        Passenger pass = new Passenger();
//        pass.setPassenger_id(1001L);
//        pass.setPassenger_name("Anna Frank");
//        pass.setPass_phone("99-714-8199");
//        pass.setPass_country("Netherlands");
//        pass.setPass_city("Amsterdam");
//        System.out.println(passengerServiceImp.save(pass));
//        System.out.println(passengerServiceImp.update(pass));
        passengerServiceImp.delete(1003);



    }
}