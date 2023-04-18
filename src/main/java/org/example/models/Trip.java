package org.example.models;

import java.sql.Timestamp;

public class Trip {

    private int trip_number;
    private int company_id;
    private String trip_organizer;
    private String departure_city;
    private String destination_city;
    private Timestamp time_departure;
    private Timestamp time_arrival;

    public Trip(int trip_number, int company_id, String trip_organizer, String departure_city,
                String destination_city, Timestamp time_departure, Timestamp time_arrival) {
        this.trip_number = trip_number;
        this.company_id = company_id;
        this.trip_organizer = trip_organizer;
        this.departure_city = departure_city;
        this.destination_city = destination_city;
        this.time_departure = time_departure;
        this.time_arrival = time_arrival;
    }
    public Trip(){}

    public int getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(int trip_number) {
        this.trip_number = trip_number;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTrip_organizer() {
        return trip_organizer;
    }

    public void setTrip_organizer(String trip_organizer) {
        this.trip_organizer = trip_organizer;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public Timestamp getTime_departure() {
        return time_departure;
    }

    public void setTime_departure(Timestamp time_departure) {
        this.time_departure = time_departure;
    }

    public Timestamp getTime_arrival() {
        return time_arrival;
    }

    public void setTime_arrival(Timestamp time_arrival) {
        this.time_arrival = time_arrival;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip_number=" + trip_number +
                ", company_id=" + company_id +
                ", trip_organizer='" + trip_organizer + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", destination_city='" + destination_city + '\'' +
                ", time_departure=" + time_departure +
                ", time_arrival=" + time_arrival +
                '}';
    }
}
