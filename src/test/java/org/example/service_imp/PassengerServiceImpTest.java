package org.example.service_imp;

import org.example.models.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImpTest {
    PassengerServiceImp ps = new PassengerServiceImp();
    Passenger pass = new Passenger();
    @Test
    void getById() {
        pass.setPassenger_id(1003L);
        pass.setPassenger_name("Anna Frank");
        pass.setPass_phone("99-714-8199");
        pass.setPass_country("Netherlands");
        pass.setPass_city("Amsterdam");
        assertSame(ps.save(pass), ps.getById(1003L));
    }

}