package org.example.tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Company {
    private String companyName;
    private LocalDate foundDate;

    public Company(String companyName, String foundDate) {
        this.companyName = companyName;
        this.foundDate = setFoundDate(foundDate);
    }


    public LocalDate setFoundDate(String inputDate) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("yyyy-MM-dd")
                .toFormatter(Locale.ENGLISH);
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate outputDate = LocalDate.parse(inputDate, formatter);
        return outputDate;
    }

}
