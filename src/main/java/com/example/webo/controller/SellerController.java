package com.example.webo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.webo.model.Seller;
import com.example.webo.service.SellerService;
@Controller
public class SellerController {
	@Autowired
    SellerService sellerservice;
 @PostMapping("/addSeller")
    public String addUser(@RequestParam("id") Long id,
    					  @RequestParam("sellerName") String sellerName,
    					  @RequestParam("phone") String phone,
    					  @RequestParam("email") String email,
    					  @RequestParam("addressLine1") String addressLine1,
                          @RequestParam("addressLine2") String addressLine2,
                          @RequestParam("postcode") String postcode,
                          @RequestParam("city") String city,
                          @RequestParam("businessName") String businessName,
                          @RequestParam("businessType") String businessType,
                          @RequestParam("website") String website,
                          @RequestParam("pancard") String pancard,
                          @RequestParam("gst") String gst,
                          @RequestParam("username") String username,
                          @RequestParam("status") String status,Model model) {
                          
                          
                          
                          
                          

        boolean mobileExists = sellerservice.checkphone(phone);
        if (!mobileExists) {
        	Seller seller = new Seller();
        	seller.setId(id);
            seller.setSellerName(sellerName);
            seller.setPhone(phone);
            seller.setEmail(email);
            seller.setAddressLine1(addressLine1);
            seller.setAddressLine2(addressLine2);
            seller.setPostcode(postcode);
            seller.setCity(city);
            seller.setPhone(phone);
            seller.setBusinessName(businessName);
            seller.setBusinessType(businessType);
            seller.setWebsite(website);
            seller.setPancard(pancard);
            seller.setGst(gst);
            seller.setUsername(username);
            seller.setStatus(status);
            
           

            sellerservice.addSeller(seller);
           // modecus.addAttribute("successMessage", "User registered successfully");
            
            System.out.println("seller registered successfully");
            return "redirect:/home";
            //return "redirect:/register?success";
        } else {
        	
        	
            System.out.println("Customer already exists!");
            
            return "redirect:/index";
        }
    }
    @GetMapping("/sellers")
    public String listRegisteredUsers(Model model){
        List<Seller> sellers = sellerservice.findAllSeller();
        model.addAttribute("sellers",sellers);
        return "sellers";
    }
}
