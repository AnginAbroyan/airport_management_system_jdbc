package org.example.tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Pass_in_trip {
    private int trip_id;
    private int psg_id;
    private LocalDate date;
    private String place;


    public Pass_in_trip(int trip_id, int psg_id, LocalDate date, String place) {
        this.trip_id = trip_id;
        this.psg_id = psg_id;
//        this.date = setDate(date);
        this.place = place;
    }

    public LocalDate setDate(String inputDate) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("yyyy-MM-dd")
                .toFormatter(Locale.ENGLISH);
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate outputDate = LocalDate.parse(inputDate, formatter);
        return outputDate;
    }
}
