package org.example.service;

import org.example.interfaces.PassengerInterface;
import org.example.tables.Passenger;
import org.example.tables.Trip;
import org.example.util.ConnectionUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class PassengerService implements PassengerInterface {

    @Override
    public Passenger getById(long id) {
        String query = "select * from passenger where passenger_id = ?";
        Passenger pass = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionUtil db = new ConnectionUtil();
            conn = db.connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pass = new Passenger();
                pass.setPassenger_id(id);
                pass.setPassenger_name(rs.getString("passenger_name"));
                pass.setPass_phone(rs.getString("pass_phone"));
                pass.setPass_country(rs.getString("pass_country"));
                pass.setPass_city(rs.getString("pass_city"));
                System.out.println("Passenger found::" + pass);
            } else {
                System.out.println("No passenger found with id::" + id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                rs.close();
                ps.close();
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return pass;
    }


    @Override
    public Set<Passenger> getAll() {
        return null;
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(long passengerId) {

    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
