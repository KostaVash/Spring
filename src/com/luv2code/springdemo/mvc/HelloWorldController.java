package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read from the data and add data to the model
	@RequestMapping("/processFormV2")
	public String letsShoutDude(HttpServletRequest request , Model model) {
		
		//read the request parameter from the HTML form 
		String name =request.getParameter("studentName");
		
		//convert the data to upper case 
		name = name.toUpperCase();
		
		//create the message
		String result = "YO! "+name;
		
		//add message to the model
		model.addAttribute("message" , result);
		
		return "helloworld";
	}
	
	
	//new controller method to read from the data and add data to the model spring will give use the parameter "studentName" to the string name 
		@RequestMapping("/processFormV3")
		public String processFormV3(@RequestParam("studentName") String name, Model model) {
			
			//convert the data to upper case 
			name = name.toUpperCase();
			
			//create the message
			String result = "WATCH OUT! \n "+name;
			
			//add message to the model
			model.addAttribute("message" , result);
			
			return "helloworld";
		}

}
