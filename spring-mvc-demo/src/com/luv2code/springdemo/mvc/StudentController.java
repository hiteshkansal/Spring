package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//For getting country options from properties file
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		//create a new student object
		Student theStudent = new Student();
		
		//add student object as model attribute
		theModel.addAttribute("student", theStudent);
		
		// add the country options to the model 
	    theModel.addAttribute("theCountryOptions", countryOptions); 
	    
		return "student-form";
	}
	
	//@ModelAttirbute is used for binding model data
	//It is useful when you have multiple form field. 
	//it is easy to bind using bean rather than declare them separtely as function arg.
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data
		System.out.println("Name: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		
		return "student-confirmation";
	}
}
