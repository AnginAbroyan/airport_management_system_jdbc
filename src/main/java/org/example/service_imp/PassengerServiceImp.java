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

public class PassengerServiceImp implements org.example.service.PassengerService {
    /**
     * Method gets the passenger data by passenger_id.
     * @return passenger data
     */

    @Override
    public Passenger getById(long id) {
        String query = "select * from passenger where passenger_id = ?";
        Passenger pass = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
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
        return pass;
    }

    /**
     * Method gets all passenger data from passenger table.
     * @return all information about all the passengers from table passenger.
     */
    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> passengerSet = new HashSet<>();
        String query = "select * from passenger;";
        Passenger pass = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pass = new Passenger();
                pass.setPassenger_id(rs.getLong("passenger_id"));
                pass.setPassenger_name(rs.getString("passenger_name"));
                pass.setPass_phone(rs.getString("pass_phone"));
                pass.setPass_country(rs.getString("pass_country"));
                pass.setPass_city(rs.getString("pass_city"));
                passengerSet.add(pass);
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
        return passengerSet;
    }

    /**
     * Method gets passenger data by pages.
     * @param offset from which passenger should be shown the page.
     * @param perPage how many passengers are being shown in a page
     * @param sort by which column of the passenger table
     * @return the sorted passenger data from some point to some point.
     */
    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        Set<Passenger> passengerSet = new HashSet<>();
        String query = "select * from passenger order by " + sort + " offset ? fetch next ? rows only";
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
                passengerSet.add(new Passenger(rs.getLong("passenger_id"), rs.getString("passenger_name"),
                        rs.getString("pass_phone"), rs.getString("pass_country"),
                        rs.getString("pass_city")));
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
        return passengerSet;
    }

    /**
     * Saves a new passenger into our passenger entity.
     * @param passenger will be saved
     * @return saves passenger
     */
    @Override
    public Passenger save(Passenger passenger) {
        String query = "insert into Passenger (passenger_id, passenger_name, pass_phone, pass_country, pass_city) " +
                "values (?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, passenger.getPassenger_id());
            ps.setString(2, passenger.getPassenger_name());
            ps.setString(3, passenger.getPass_phone());
            ps.setString(4, passenger.getPass_country());
            ps.setString(5, passenger.getPass_city());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Passenger saved with id="+passenger.getPassenger_id());
            }else System.out.println("Passenger save failed with id="+passenger.getPassenger_id());
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

        return passenger;
    }

    /**
     * Updates passenger by its id
     * @param passenger
     * @return the updated passenger
     */
    @Override
    public Passenger update(Passenger passenger) {
        String query = "update passenger set passenger_name=?, pass_phone=?, pass_country=?, pass_city=? where passenger_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(5, passenger.getPassenger_id());
            ps.setString(1, passenger.getPassenger_name());
            ps.setString(2, passenger.getPass_phone());
            ps.setString(3, passenger.getPass_country());
            ps.setString(4, passenger.getPass_city());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Passenger updated with id="+passenger.getPassenger_id());
            }else System.out.println("Passenger update failed with id="+passenger.getPassenger_id());
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

        return passenger;
    }

    /**
     * Deletes a company from an entity by passenger_id
     * @param passengerId
     */
    @Override
    public void delete(long passengerId) {
        String query = "delete from passenger where passenger_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, passengerId);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Passenger deleted with id="+passengerId);
            }else System.out.println("Passenger delete failed with id="+passengerId);
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
