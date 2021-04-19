package edu.rufus.patientservice;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prescription {
	private long id;
	private String description;
	private Map<Long, Medicine> prescriptions = new HashMap<Long, Medicine>();
	public Prescription() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
