package org.example.models;

import java.sql.Date;

public class Company {


    private Long company_id;
    private String company_name;
    private Date found_date;

    public Company(Long company_id, String company_name, Date found_date) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.found_date = found_date;
    }

    public Company() {

    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Date getFound_date() {
        return found_date;
    }

    public void setFound_date(Date found_date) {
        this.found_date = found_date;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", companyName='" + company_name + '\'' +
                ", foundDate=" + found_date +
                '}';
    }
}
