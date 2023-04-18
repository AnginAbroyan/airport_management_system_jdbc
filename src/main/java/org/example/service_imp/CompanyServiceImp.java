package org.example.service_imp;


import org.example.models.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.example.connection_util.ConnectionUtil.connectDB;

public class CompanyServiceImp implements org.example.service.CompanyService {

    /**
     * Method gets the company data by company_id.
     * @return company data
     */
    @Override
    public Company getById(long id) {
        String query = "select * from company where company_id = ?";
        Company company = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                company = new Company();
                company.setCompany_id(id);
                company.setCompany_name(rs.getString("companyName"));
                company.setFound_date(rs.getDate("foundDate"));
                System.out.println("Company found::" + company);
            } else {
                System.out.println("No company found with id::" + id);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return company;
    }
    /**
     * Method gets all company data from company entity.
     * @return all information about all the companies from entity company.
     */
    @Override
    public Set<Company> getAll() {
        Set<Company> companySet = new HashSet<>();
        String query = "select * from company;";
        Company company = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                company = new Company();
                company.setCompany_id(rs.getLong("company_id"));
                company.setCompany_name(rs.getString("companyName"));
                company.setFound_date(rs.getDate("foundDate"));
                companySet.add(company);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return companySet;
    }
    /**
     * Method gets company data by pages.
     * @param offset from which company should be shown the page.
     * @param perPage how many companies are being shown in a page
     * @param sort by which column of the company table
     * @return the sorted company data from some point to some point.
     */
    @Override
    public Set<Company> get(int offset, int perPage, String sort) {

        Set<Company> companySet = new HashSet<>();
        String query = "select * from company order by " + sort + " offset ? fetch next ? rows only";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setInt(1, offset);
            ps.setInt(2, perPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                companySet.add(new Company(rs.getLong("company_id"), rs.getString("companyName"),
                        rs.getDate("foundDate")));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return companySet;
    }
    /**
     * Saves a new company into our passenger entity.
     * @param company will be saved
     * @return saves company
     */
    @Override
    public Company save(Company company) {
        String query = "insert into Company (company_id, company_name, found_date) values (?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, company.getCompany_id());
            ps.setString(2, company.getCompany_name());
            ps.setDate(3, company.getFound_date());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Company saved with id="+company.getCompany_id());
            }else System.out.println("Company save failed with id="+company.getCompany_id());
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        return company;
    }
    /**
     * Updates company by its id
     * @param company
     * @return the updated company
     */
    @Override
    public Company update(Company company) {
        String query = "update company set company_name=?, found_date=? where company_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(3, company.getCompany_id());
            ps.setString(1, company.getCompany_name());
            ps.setDate(2, company.getFound_date());

            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Company updated with id="+company.getCompany_id());
            }else System.out.println("Company update failed with id="+company.getCompany_id());
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        return company;
    }
    /**
     * Deletes a passenger from an entity by company_id
     * @param companyId
     */
    @Override
    public void delete(long companyId) {
        String query = "delete from company where company_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectDB();
            ps = conn.prepareStatement(query);
            ps.setLong(1, companyId);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Company deleted with id="+companyId);
            }else System.out.println("Company delete failed with id="+companyId);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
