package com.pranav.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pranav.springdemo.entity.Customer;
import com.pranav.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel)
	{
		List<Customer> theCustomer=customerService.getCustomer();
		theModel.addAttribute("customers",theCustomer);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel)
	{
			Customer theCustomer=new Customer();
			theModel.addAttribute("addCustomer",theCustomer);
		return "showFormForAdd";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("addCustomer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormforUpdate(@RequestParam("customerId") int theId,Model theModel )
	{
		Customer theCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("addCustomer",theCustomer);
		
		return "showFormForAdd";
	
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId,Model theModel)
	{
			customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	//sweeti 
	
}
