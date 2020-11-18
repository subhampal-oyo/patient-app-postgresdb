package com.subham.patient.app.dao;

import com.subham.patient.app.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository("internal db")
public class PatientDaoIntDB implements PatientDao {
    private static Map<Integer, Patient> patients;
    static{
        patients= new HashMap<Integer,Patient>(){
            {
                put(101,new Patient(101,"Subham","Cured"));
                put(102,new Patient(102,"Ravi","Not Cured"));
                put(103,new Patient(103,"Sourav","Not Cured"));
                put(104,new Patient(104,"Abhik","Cured"));
            }
        };
    }
    @Override
    public Collection<Patient> getAllPatients(){
        return this.patients.values();
    }
    @Override
    public Patient getPatientById(int id){
        return this.patients.get(id);
    }

    @Override
    public void removePatientById(int id) {
        this.patients.remove(id);
    }
    @Override
    public void updatePatient(Patient patient){
        Patient p1=patients.get(patient.getId());
        p1.setStatus(patient.getStatus());
        p1.setName(patient.getName());
        patients.put(patient.getId(),patient);
    }
    @Override
    public void insertPatientToDB(Patient patient){
        this.patients.put(patient.getId(),patient);
    }
}
