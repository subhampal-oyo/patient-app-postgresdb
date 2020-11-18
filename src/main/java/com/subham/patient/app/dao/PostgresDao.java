package com.subham.patient.app.dao;

import com.subham.patient.app.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository("postgres")
public class PostgresDao implements PatientDao {
    private  JdbcTemplate jdbcTemplate;

   @Autowired
    public PostgresDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Patient> getAllPatients() {
       String sql="SELECT id,name,status FROM patient";
         return jdbcTemplate.query(sql,(resultSet, i) -> {
           int newid=Integer.parseInt(resultSet.getString("id"));
           String newname=resultSet.getString("name");
                   String newstatus= resultSet.getString("status");
                   return new Patient(newid,newname,newstatus);
        });
    }

    @Override
    public Patient getPatientById(int id) {
        String sql="SELECT id,name,status FROM patient WHERE id=?";
         Patient patient = jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet, i) -> {
            int newid=Integer.parseInt(resultSet.getString("id"));
            String newname=resultSet.getString("name");
            String newstatus= resultSet.getString("status");
            return new Patient(newid,newname,newstatus);
        });
         return patient;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public void removePatientById(int id) {
        String sql="DELETE FROM patient WHERE id=?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updatePatient(Patient patient) {
     String sql="UPDATE patient set name=?,status=? WHERE id=?";
     // have to object parameters according to question mark in the sql query
     this.jdbcTemplate.update(sql,patient.getName(),patient.getStatus(),patient.getId());
    }

    @Override
    public void insertPatientToDB(Patient patient) {
       String sql="INSERT INTO patient(id,name ,status) VALUES(?,?,?)";
       this.jdbcTemplate.update(sql,patient.getId(),patient.getName(),patient.getStatus());

    }
}
