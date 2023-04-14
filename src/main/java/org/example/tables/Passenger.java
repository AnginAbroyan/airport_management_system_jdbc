package org.example.tables;

public class Passenger {
    private Long passenger_id;
    private String passenger_name;
    private String pass_phone;
    private String pass_country;
    private String pass_city;

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
}
