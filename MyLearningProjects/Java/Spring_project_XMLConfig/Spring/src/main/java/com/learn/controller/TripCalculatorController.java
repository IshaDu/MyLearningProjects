package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.learn.service.TripCostCalculatorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TripCalculatorController {
	@Autowired 
	TripCostCalculatorService tripCostCalculatorService ;
	
	@RequestMapping("/calculateTripCost")
	public ModelAndView calculateTripCost(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		double costOfTravel =0.0 ;
		String errorMessage= "";
		 if(req.getParameter("carMileageInputBox").equals(null) || 
		    req.getParameter("gasPriceInputBox").equals(null) ||
		    req.getParameter("distanceTraveledInputBox").equals(null)||
		    req.getParameter("carMileageInputBox").equals("") ||
		    req.getParameter("gasPriceInputBox").equals("") ||
		    req.getParameter("distanceTraveledInputBox").equals("")) 
		 {
			 errorMessage = "Enter Valid Values.";
			 mv.setViewName("carTripDetails");
			 mv.addObject("error", errorMessage);
			 mv.addObject("cost", 0.0);
		 }else {
			 float carMileage =  Float.parseFloat(req.getParameter("carMileageInputBox"));
			 float gasPrice =  Float.parseFloat(req.getParameter("gasPriceInputBox"));
			 float distanceTraveled =  Float.parseFloat(req.getParameter("distanceTraveledInputBox"));
			 System.out.println("carMileage is : "+carMileage+"gasPrice is : "+gasPrice);
			 costOfTravel = tripCostCalculatorService.costCalculator(carMileage, gasPrice, distanceTraveled);
			 mv.setViewName("carTripDetails");
			 mv.addObject("cost", costOfTravel);
			 mv.addObject("error", "");
		 }
		return mv;
	}
}
