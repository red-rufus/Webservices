package edu.rufus.patientservice;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("patients")
public class PatientServiceImpl implements PatientService {
	private static long currentId = 100;
	private static Map<Long, Patient> patients = new HashMap<Long, Patient>();
	private static Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();
	
	public PatientServiceImpl() {
		init();
	}

	private void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("Rajat");
		patients.put(patient.getId(), patient);
		
		Prescription prescription = new Prescription();
		prescription.setId(200);
		prescription.setDescription("Sample Prescription");
		prescriptions.put(prescription.getId(), prescription);
	}

	@Override
	@GET
	@Path("patient/{id}/")
	@Produces({"application/xml", "application/json"})
	public Patient getPatient(@PathParam("id") String id) {
		System.out.println("PatientServiceImpl.getPatient()");
		System.out.println(patients);
		return patients.get(Long.parseLong(id));
	}

	@Override
	@PUT
	@Path("patient/")
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/xml", "application/json"})
	public Response updatePatient(Patient updatedPatient) {
		System.out.println("PatientServiceImpl.updatePatient() "+updatedPatient);
		Patient currentPatient = patients.get(updatedPatient);
		Response response = null;
		if(currentPatient != null) {
			patients.put(updatedPatient.getId(), updatedPatient);
			response = Response.ok("success").build();
		} else {
			response = Response.notModified("not modified").build();
		}
		System.out.println(patients);
		return response;
	}

	@Override
	@POST
	@Path("patient/")
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/xml", "application/json"})
	public Patient addPatient(Patient patient) {
		System.out.println("PatientServiceImpl.addPatient() "+patient);
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		System.out.println(patients);
		return patient;
	}

	@Override
	@DELETE
	@Path("patient/{id}/")
	public Response deletePatient(@PathParam("id") String id) {
		System.out.println("PatientServiceImpl.deletePatient()");
		Response response = null;
		Long patientId = Long.parseLong(id);
		if(patients.get(patientId) != null) {
			patients.remove(patientId);
			response = Response.ok("success").build();
		}
		response = Response.notModified("not modified").build();
		System.out.println(patients);
		return response; 
	}

	@Override
	public Prescription getPrescription(String presciptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
