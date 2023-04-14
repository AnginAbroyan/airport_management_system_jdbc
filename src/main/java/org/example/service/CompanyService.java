package org.example.service;


import org.example.interfaces.CompanyInterface;
import org.example.tables.Company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Set;

public class CompanyService implements CompanyInterface {


    @Override
    public Company getById(long id) {
        return null;
    }

    @Override
    public Set<Company> getAll() {
        return null;
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company passenger) {
        return null;
    }

    @Override
    public Company update(Company passenger) {
        return null;
    }

    @Override
    public void delete(long companyId) {

    }
}
