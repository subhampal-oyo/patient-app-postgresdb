package com.subham.patient.app.dao;

import com.subham.patient.app.model.Patient;

import java.util.Collection;

public interface PatientDao {
    Collection<Patient> getAllPatients();

    Patient getPatientById(int id);

    void removePatientById(int id);

    void updatePatient(Patient patient);

    void insertPatientToDB(Patient patient);
}
