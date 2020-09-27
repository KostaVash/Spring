package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an initbinder to convert trim input strings 
	//remove leading and trailing whitespace
	//resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		databinder.registerCustomEditor(String.class , stringTrimmerEditor);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("customer",new Customer());

		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid@ModelAttribute("customer")Customer customer,BindingResult bindingResult) {
		
		System.out.println("\n>>Logged: "+customer.getFirstName()+" "+customer.getLastName());
		
		System.out.println("\nBinding Result: "+bindingResult);
		System.out.println("\nProduct ID : "+customer.getProductID());
		
		System.out.println("\n");

		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";}
	}
	
	

}
