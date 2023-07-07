	package com.example.webo.controller;
	
	
	import org.json.JSONObject;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	
	import com.razorpay.Order;
	import com.razorpay.RazorpayClient;
	import com.razorpay.RazorpayException;
	
	
	@Controller
	public class OrderCreation {
		@PostMapping("/payNow")
		@ResponseBody
		public String createOrder(@RequestParam("amount") String amount) {
			Order order=null;
			try {
				RazorpayClient razorpay=new RazorpayClient("rzp_test_9yNjcoFdlorgqd", "rlPiaJjCGysu4vo63DK3n94Q");
				
				JSONObject orderRequest = new JSONObject();
				
				 int convertedAmount = Integer.parseInt(amount);
				int multiplier = 100; // Set the appropriate multiplier based on your currency (e.g., 100 for INR)
	
			    int totalAmount = convertedAmount * multiplier;
			    orderRequest.put("amount", totalAmount); // Set the total order amount
				
				  orderRequest.put("currency", "INR");
				  orderRequest.put("receipt", "order_rcptid_11");
	
				  order = razorpay.orders.create(orderRequest);
				  
				  System.out.println(order);
			
			} catch (RazorpayException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally {
			        if (order != null) {
			            return order.toString();
			        } else {
			            // Handle the case when order is null (e.g., return an appropriate error message)
			            return "Error creating order";
			        }
			    }
			}
	}