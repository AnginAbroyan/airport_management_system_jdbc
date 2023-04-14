package org.example.interfaces;

import org.example.tables.Trip;

import java.util.List;
import java.util.Set;

public interface TripInterface {

    Trip getById(long id);
    Set<Trip> getAll();
    Set<Trip> get(int offset, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger);
    void delete(long tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);


}
