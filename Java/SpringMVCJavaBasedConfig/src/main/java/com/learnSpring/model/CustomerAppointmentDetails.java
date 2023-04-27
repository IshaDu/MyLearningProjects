package com.learnSpring.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAppointmentDetails {
	private String firstName;
	private String lastName;
	private String apptDate;
	private String apptTime;
	private String beautyTreatmentName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	public String getApptTime() {
		return apptTime;
	}
	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}
	public String getBeautyTreatmentName() {
		return beautyTreatmentName;
	}
	public void setBeautyTreatmentName(String beautyTreatmentName) {
		this.beautyTreatmentName = beautyTreatmentName;
	}

	

}
