package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.PaymentDao;
import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.exception.PaymentIdNotFound;
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

	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Payment into db");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetchPaymentById from db");
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Payment>> fetchAllPayment() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetched All Payments from db");
		responseStructureList.setData(paymentDao.fetchAllPayment());
		return new ResponseEntity<ResponseStructureList<Payment>>(responseStructureList,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted Payment By Id from db");
			responseStructure.setData(paymentDao.deletePaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated Payment By Id from db");
			responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}
}
