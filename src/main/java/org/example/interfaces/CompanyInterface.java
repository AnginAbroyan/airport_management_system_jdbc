package org.example.interfaces;

import org.example.tables.Company;

import java.util.Set;

public interface  CompanyInterface {

    Company getById(long id);
    Set<Company> getAll();
    Set<Company> get(int offset, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(long companyId);


}
