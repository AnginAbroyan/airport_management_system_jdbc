package org.example.service_imp;

import org.example.models.Passenger;
import org.example.models.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.connection_util.ConnectionUtil.connectDB;

public class TripServiceImp implements org.example.service.TripService {
    @Override
    public Trip getById(long id) {

        String query = "select * from trip where trip_number= ?";
        Trip trip = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                trip = new Trip();
                trip.setTrip_number((int)id);
                trip.setCompany_id(rs.getInt("company_id"));
                trip.setTrip_organizer(rs.getString("trip_organizer"));
                trip.setDeparture_city(rs.getString("departure_city"));
                trip.setDestination_city(rs.getString("destination_city"));
                trip.setTime_departure(rs.getTimestamp("time_departure"));
                trip.setTime_arrival(rs.getTimestamp("time_arrival"));
                System.out.println("Trip found::" + trip);
            } else {
                System.out.println("No trip found with id::" + id);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return trip;
    }

    @Override
    public Set<Trip> getAll() {
        Set<Trip> tripSet = new HashSet<>();
        String query = "select * from trip;";
        Trip trip = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                trip = new Trip();
                trip.setTrip_number(rs.getInt("trip_number"));
                trip.setCompany_id(rs.getInt("company_id"));
                trip.setTrip_organizer(rs.getString("trip_organizer"));
                trip.setDeparture_city(rs.getString("departure_city"));
                trip.setDestination_city(rs.getString("destination_city"));
                trip.setTime_departure(rs.getTimestamp("time_departure"));
                trip.setTime_arrival(rs.getTimestamp("time_arrival"));
                tripSet.add(trip);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return tripSet;
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        Set<Trip> tripSet = new HashSet<>();
        String query = "select * from trip order by " + sort + " offset ? fetch next ? rows only";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setInt(1, offset);
            ps.setInt(2, perPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                tripSet.add(new Trip(rs.getInt("trip_number"), rs.getInt("company_id"),
                        rs.getString("trip_organizer"), rs.getString("departure_city"),
                        rs.getString("destination_city"), rs.getTimestamp("time_departure"), rs.getTimestamp("time_arrival")));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return tripSet;
    }

    @Override
    public Trip save(Trip trip) {
        String query = "insert into Trip (trip_number, company_id, trip_organizer, departure_city, destination_city," +
                " time_departure, time_arrival) values (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setInt(1, trip.getTrip_number());
            ps.setInt(2, trip.getCompany_id());
            ps.setString(3, trip.getTrip_organizer());
            ps.setString(4, trip.getDeparture_city());
            ps.setString(5, trip.getDestination_city());
            ps.setTimestamp(6, trip.getTime_departure());
            ps.setTimestamp(7, trip.getTime_arrival());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Trip saved with id="+trip.getTrip_number());
            }else System.out.println("Trip save failed with id="+trip.getTrip_number());
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        return trip;
    }

    @Override
    public Trip update(Trip trip) {
        String query = "update trip set company_id=?,trip_organizer=?, departure_city=?, destination_city=?," +
                " time_departure=?, time_arrival=? where trip_number=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setInt(7, trip.getTrip_number());
            ps.setInt(1, trip.getCompany_id());
            ps.setString(2, trip.getTrip_organizer());
            ps.setString(3, trip.getDeparture_city());
            ps.setString(4, trip.getDestination_city());
            ps.setTimestamp(5, trip.getTime_departure());
            ps.setTimestamp(6, trip.getTime_arrival());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Trip updated with id="+trip.getTrip_number());
            }else System.out.println("Trip update failed with id="+trip.getTrip_number());
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        return trip;
    }

    @Override
    public void delete(long tripId) {
        String query = "delete from trip where trip_number=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, tripId);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Passenger deleted with id="+tripId);
            }else System.out.println("Passenger delete failed with id="+tripId);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
