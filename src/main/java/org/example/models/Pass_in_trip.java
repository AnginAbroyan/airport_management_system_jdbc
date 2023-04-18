package org.example.models;

import java.sql.Timestamp;

public class Pass_in_trip {
    private int trip_id;
    private int psg_id;
    private Timestamp date;
    private String place;


    public Pass_in_trip(int trip_id, int psg_id, Timestamp date, String place) {
        this.trip_id = trip_id;
        this.psg_id = psg_id;
        this.date = date;
        this.place = place;
    }

    public Pass_in_trip(){
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public int getPsg_id() {
        return psg_id;
    }

    public void setPsg_id(int psg_id) {
        this.psg_id = psg_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Pass_in_trip{" +
                "trip_id=" + trip_id +
                ", psg_id=" + psg_id +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }
}
