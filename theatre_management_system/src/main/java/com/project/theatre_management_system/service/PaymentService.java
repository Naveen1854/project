package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.PaymentDao;
import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	@Autowired
	ResponseStructureList<Payment> responseStructureList;
	
	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Manager into db");
		responseStructure.setData(paymentDao.savePayment(payment));
		return responseStructure;
	}
	
	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully saved the Manager into db");
		responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
		return responseStructure;
	}
	
	public ResponseStructureList<Payment> fetchAllPayment() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(paymentDao.fetchAllPayment());
		return responseStructureList;
	}
	
	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return responseStructure;
	}
	
	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId, Payment newPayment) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
		return responseStructure;
	}
}
