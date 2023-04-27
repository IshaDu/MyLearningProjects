package com.learnSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnSpring.dao.BeautyTreatmentDAO;
import com.learnSpring.model.BeautyTreatments;
import com.learnSpring.model.CustomerAppointmentDetails;
import com.learnSpring.model.Users;

@Controller
public class BeautyTreatmentController {

	@Autowired
	BeautyTreatmentDAO beautyTreatmentDAO ;
	
	@RequestMapping("addBeautyTreatment")
	public String addBeautyTreatment(@RequestParam("treatmentNameInputBox") String beautyTreatmentName,
			@RequestParam("treatmentPriceInputBox") String treatmentPrice) {
		System.out.println("Beauty Treatment Name is: "+beautyTreatmentName);
		System.out.println("Beauty Treatment Price is: "+treatmentPrice);
		
		BeautyTreatments beautyTreatments = new BeautyTreatments();  
		beautyTreatments.setBeautyTreatmentName(beautyTreatmentName);
		beautyTreatments.setBeautyTreatmentPrice(treatmentPrice);		
				
		beautyTreatmentDAO.addBeautyTreatments(beautyTreatments.getBeautyTreatmentName(), 
														beautyTreatments.getBeautyTreatmentPrice());
		//Adding beautyTreatmentDetails from addBeautyTreatments.jsp to listBeautyTreatments.jsp
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listBeautyTreatments");
		mv.addObject("listBeautyTreatments",beautyTreatments.toString().lines());
		
		return "addBeautyTreatments";
	}
	
	@RequestMapping("viewAllBeautyTreatments")
	public ModelAndView viewAllBeautyTreatmentsAvailable() {
		List<BeautyTreatments> beautyTreatments = new ArrayList<BeautyTreatments>();
		System.out.println("Inside controller view method: ");
		beautyTreatments = beautyTreatmentDAO.viewAllBeautyTreatmentsAvailable();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listBeautyTreatments");
		mv.addObject("listBeautyTreatments",beautyTreatments);
		
		return mv;
	}
	
	@RequestMapping("backToWelcomeForm")
	public String backToWelcomeForm() {
		return "welcomeForm";
	}
	
	
	@RequestMapping("bookbeautyAppointmentPage")
	public ModelAndView bookBeautyAppointment() {
		List<BeautyTreatments> beautyTreatments = new ArrayList<BeautyTreatments>();
		beautyTreatments = beautyTreatmentDAO.viewAllBeautyTreatmentsAvailable();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookAppointment");
		mv.addObject("listBeautyTreatments",beautyTreatments);
		return mv;
	}
	
	@RequestMapping("bookAppointment")
	public String bookAppointmentForBeautyTreatment(@RequestParam("apptDateInputBox") String apptDate,
			@RequestParam("apptTimeInputBox") String apptTime,
			@RequestParam("beautyTreatmentNameSelectionBox") String beautyTreatmentName,
			@RequestParam("customerFirstNameInputBox") String customerFirstName,
			@RequestParam("customerLastNameInputBox") String customerLastName
			) {
		System.out.println("Customer First Name is : "+customerFirstName);
		System.out.println("Customer Last Name is : "+customerLastName);
		System.out.println("Appointment Date is : "+apptDate);
		System.out.println("Appointment Time is : "+apptTime);
		System.out.println("Beauty Treatment Name is : "+beautyTreatmentName);
		
		CustomerAppointmentDetails customerAppointmentDetails = new CustomerAppointmentDetails(); 
		customerAppointmentDetails.setFirstName(customerFirstName);
		customerAppointmentDetails.setLastName(customerLastName);
		customerAppointmentDetails.setApptDate(apptDate);
		customerAppointmentDetails.setApptTime(apptTime);
		customerAppointmentDetails.setBeautyTreatmentName(beautyTreatmentName);
		
		beautyTreatmentDAO.saveCustomerBeautyTreatmentApptmentDetails(customerAppointmentDetails);
		
		return "bookAppointment";
	}
}
