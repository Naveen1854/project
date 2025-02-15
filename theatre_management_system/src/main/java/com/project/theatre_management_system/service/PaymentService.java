package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.PaymentDao;
import com.project.theatre_management_system.dto.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	
	public Payment savePayment(Payment payment) {
		return paymentDao.savePayment(payment);
	}
	
	public Payment fetchPaymentById(int paymentId) {
		return paymentDao.fetchPaymentById(paymentId);
	}
	
	public List<Payment> fetchAllPayment() {
		return paymentDao.fetchAllPayment();
	}
	
	public Payment deletePaymentById(int paymentId) {
		return paymentDao.deletePaymentById(paymentId);
	}
	
	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		return paymentDao.updatePaymentById(oldPaymentId, newPayment);
	}
}
