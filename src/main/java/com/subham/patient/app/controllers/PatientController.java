package com.subham.patient.app.controllers;

import com.subham.patient.app.model.Patient;
import com.subham.patient.app.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientsService patientService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public Patient getPatientById(@PathVariable("id") int id){
        return patientService.getPatientById(id);
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
        public void deleteStudentById(@PathVariable("id") int id){
           patientService.removePatientById(id);

    }
    @RequestMapping(method=RequestMethod.PUT,consumes= MediaType.APPLICATION_JSON_VALUE)
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }
    @RequestMapping(method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public void insertPatient(@RequestBody Patient patient) {
        patientService.insertPatient(patient);
    }
}
