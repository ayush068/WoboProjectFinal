package com.example.webo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.webo.model.Customer;
import com.example.webo.service.CustomerService;


@Controller
public class CustomerController {
	@Autowired
    CustomerService customerservice;
 @PostMapping("/addCustomer")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("country") String country,
                          @RequestParam("addressLine1") String addressLine1,
                          @RequestParam("addressLine2") String addressLine2,
                          @RequestParam("postcode") String postcode,
                          @RequestParam("city") String city,
                          @RequestParam("phone") String phone,
                          @RequestParam("email") String email,
                          @RequestParam("additionalInfo") String additionalInfo,Model model) {
                          
                          
                          
                          
                          

        boolean mobileExists = customerservice.checkphone(phone);
        if (!mobileExists) {
        	Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setCountry(country);
            customer.setAddressLine1(addressLine1);
            customer.setAddressLine2(addressLine2);
            customer.setPostcode(postcode);
            customer.setCity(city);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setAdditionalInfo(additionalInfo);
           

            customerservice.addCustomer(customer);
           // modecus.addAttribute("successMessage", "User registered successfully");
            
            System.out.println("Customer registered successfully");
            return "redirect:/home";
            //return "redirect:/register?success";
        } else {
        	
        	
            System.out.println("Customer already exists!");
            
            return "redirect:/index";
        }
    }
    @GetMapping("/customers")
    public String listRegisteredUsers(Model model){
        List<Customer> customers = customerservice.findAllCustomer();
        model.addAttribute("customers",customers );
        return "customers";
    }
}