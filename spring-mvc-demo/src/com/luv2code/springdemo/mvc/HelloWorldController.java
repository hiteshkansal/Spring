package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	//need a controller method to process form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	//need a controller to read form data and adding data to model
	@RequestMapping("/processFormVerionTwo")
	public String letsShout(HttpServletRequest req, Model model){
		
		//read the req param from html form
		String theName = req.getParameter("studentName");
		
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create message
		String result = "Yo! "+theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
