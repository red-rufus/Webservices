package edu.rufus.patientservice;

import javax.ws.rs.core.Response;

public interface PatientService {

	Patient getPatient(String id);

	Response updatePatient(Patient patient);

	Patient addPatient(Patient patient);

	Response deletePatient(String id);

	Prescription getPrescription(String presciptionId);
}
