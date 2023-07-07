package com.example.webo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	  @Id
	    @Column(name = "order_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany
	    private List<OrderDetails> orderDetails;

	    private double totalAmount;

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<OrderDetails> getOrderDetails() {
			return orderDetails;
		}

		public void setOrderDetails(List<OrderDetails> orderDetails) {
			this.orderDetails = orderDetails;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
	    
}
