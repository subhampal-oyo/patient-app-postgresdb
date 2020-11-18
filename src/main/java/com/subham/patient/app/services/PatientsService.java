package com.subham.patient.app.services;

import com.subham.patient.app.dao.PatientDao;
import com.subham.patient.app.dao.PatientDaoIntDB;
import com.subham.patient.app.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class PatientsService {
    private PatientDao patientDao;
@Autowired
    public PatientsService(@Qualifier("postgres") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public Collection<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }
    public Patient getPatientById(int id){
        return this.patientDao.getPatientById(id);
    }

    public void removePatientById(int id) {
        this.patientDao.removePatientById(id);
    }
    public void updatePatient(Patient patient){
        this.patientDao.updatePatient(patient);
    }

    public void insertPatient(Patient patient) {
        this.patientDao.insertPatientToDB(patient);
    }
}