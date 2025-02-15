package com.project.theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/savePayment")
	public Payment savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	@GetMapping("/fetchPaymentById")
	public Payment fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	
	@GetMapping("/fetchAllPayment")
	public List<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
	
	@DeleteMapping("/deletePaymentById")
	public Payment deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	
	@PutMapping("/updatePaymentById")
	public Payment updatePaymentById(@RequestParam int oldPaymentId, @RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
}
