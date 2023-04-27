package com.learnSpring.dao;

import java.util.List;

import com.learnSpring.model.BeautyTreatments;
import com.learnSpring.model.CustomerAppointmentDetails;
import com.learnSpring.model.Users;

public interface BeautyTreatmentDAO {
	void addBeautyTreatments(String beautyTreatmentName, String beautyTreatmentPrice);
	void saveBeautyTreatmentsNewUser(Users user);
	boolean verifyUser(String userName, String password);
	List<BeautyTreatments> viewAllBeautyTreatmentsAvailable();
	void saveCustomerBeautyTreatmentApptmentDetails(CustomerAppointmentDetails customerAppointmentDetails);
}
