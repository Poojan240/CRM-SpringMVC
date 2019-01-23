package com.code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.springdemo.dao.CustomerDAO;
import com.code.springdemo.entity.Customer;
import com.code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model themodel){
		
		//get Customers from the Service
		List<Customer> theCustomers = CustomerService.getCustomers();
		
		//add the customers to the model 
		themodel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel){
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		themodel.addAttribute("customer",theCustomer);
		return "customer-form";
	}

}
