package org.example.models;

import java.util.Objects;

public class Passenger {
    private Long passenger_id;
    private String passenger_name;
    private String pass_phone;
    private String pass_country;
    private String pass_city;

    public Passenger(Long passenger_id, String passenger_name, String pass_phone, String pass_country, String pass_city) {
        super();
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;
        this.pass_phone = pass_phone;
        this.pass_country = pass_country;
        this.pass_city = pass_city;
    }

    public Passenger() {
    }

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPass_phone() {
        return pass_phone;
    }

    public void setPass_phone(String pass_phone) {
        this.pass_phone = pass_phone;
    }

    public String getPass_country() {
        return pass_country;
    }

    public void setPass_country(String pass_country) {
        this.pass_country = pass_country;
    }

    public String getPass_city() {
        return pass_city;
    }

    public void setPass_city(String pass_city) {
        this.pass_city = pass_city;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_id=" + passenger_id +
                ", passenger_name='" + passenger_name + '\'' +
                ", pass_phone='" + pass_phone + '\'' +
                ", pass_country='" + pass_country + '\'' +
                ", pass_city='" + pass_city + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(passenger_id, passenger_name, pass_phone,pass_country, pass_city);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Passenger other = (Passenger) obj;
        return Objects.equals(passenger_name, other.passenger_name) && Objects.equals(pass_phone, other.pass_phone) &&
                Objects.equals(pass_country, other.pass_country) && Objects.equals(pass_city, other.pass_city);
    }
}
