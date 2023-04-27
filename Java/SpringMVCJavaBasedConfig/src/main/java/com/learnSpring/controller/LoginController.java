package com.learnSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnSpring.dao.BeautyTreatmentDAO;
import com.learnSpring.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	private BeautyTreatmentDAO beautyTreatmentDAO; 
	
	//-----------------------------------------------------------------------------------------------------------
	//Navigation Functions
	//this opens the registration form on click of registration form
	//Also it when Register button is clicked, it creates a new instance of Users class so that its details can 
	//be saved on click of save button on registration form
	@GetMapping("register")
	public String openRegistrationForm(@RequestParam("newUserRegistrationBtn") String registrationForm, Model model) {
		System.out.println("Here Registrations form gets opened up: "+registrationForm);
		model.addAttribute("userDetails", new Users());
		return "RegistrationForm";
	}
	
	//this takes to the welcome page on click of login button on login form
	@GetMapping("welcomePage")
	public ModelAndView openWelcomeForm(@RequestParam("loginBtn") String welcomeForm,
			@RequestParam("userNameTextBox") String userName,
			@RequestParam("PasswordTextBox") String password) {
		ModelAndView mv = new ModelAndView();
		String validUserMessage ="";
		boolean verifiedUser = beautyTreatmentDAO.verifyUser(userName,password);
		System.out.println("Value of verifiedUser : "+verifiedUser);
		if(verifiedUser) {
			mv.setViewName("welcomeForm");
			mv.addObject("validUserMessage", validUserMessage);
		}
		else {
			validUserMessage="Invalid Username or password";
			mv.setViewName("login");
			mv.addObject("validUserMessage", validUserMessage);
		}
		return mv;
	}
	
	//this opens password reset form in case user forgets the password
	@GetMapping("resetPasswordPage")
	public String openPasswordResetForm(@RequestParam("forgotPasswordBtn") String resetPasswordForm) {
		return "resetPasswordForm";		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	//Function to register user into the application
	
	//This method saves the new user details into the db on click of save button on RegistrationForm.jsp
	@PostMapping("saveUserDetails")
	public String saveUserDetails(@ModelAttribute("userDetails") Users user) {
		System.out.println("User's First Name: "+user.getFirstName());
		System.out.println("User's Last Name: "+user.getLastName());
		System.out.println("User's Age: "+user.getAge());
		System.out.println("User's Gender: "+user.getGender());
		System.out.println("User's Address: "+user.getAddress());
		System.out.println("User's Phone: "+user.getPhone());
		
		beautyTreatmentDAO.saveBeautyTreatmentsNewUser(user);
		
		return "login";
		
	}
	
}
