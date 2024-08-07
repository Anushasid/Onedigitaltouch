package com.bvb.digitaltouch.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.ResponceEntity.BvbMcaResponse;
import com.bvb.digitaltouch.dto.PaymentDto;
import com.bvb.digitaltouch.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	
	@GetMapping("/all")
	public BvbMcaResponse getAllPayment() {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	String statusMessage = "";
    	try {
    		logger.info("Trying to read all payments");
    		List<PaymentDto> payments = paymentService.getAllPayment();
    		status = HttpStatus.OK;
    		return new BvbMcaResponse(payments,status);
    	}catch(BvbMcaException e) {
    		statusMessage = "Error while reading all the payments;"+e.getMessage();
    	}catch(Exception e) {
    		e.printStackTrace();
			logger.error("Error while reading payments");
    		
    	}
    	return new BvbMcaResponse(statusMessage, status);
    }

	@PostMapping("bill-id/{billId}")
	public BvbMcaResponse createPayment(@RequestBody PaymentDto payment,@PathVariable("billId")Integer billId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage ="";
		try {
			paymentService.createPayment(payment,billId);
			status = HttpStatus.OK;
			statusMessage = "Payment is created successfully check in logger";
		}catch(BvbMcaException e) {
			statusMessage = "Error while creating or sending the payment;"+e.getMessage();
		}catch(Exception e) {
			e.printStackTrace();
		logger.error(e.getMessage());	
		
		}
		return new BvbMcaResponse(statusMessage, status);
	}
	
	@DeleteMapping("/{paymentId}")
	public BvbMcaResponse deletePayment(@PathVariable("paymentId")Integer paymentId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage = "";
		try {
			logger.info("Trying to delete the payment");
			paymentService.deletePayment(paymentId);
			status = HttpStatus.OK;
			statusMessage="payment deleted successfully";
			}catch(BvbMcaException e){
				statusMessage="Error while deleting payment "+e.getMessage();
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Error while deleting payment");
			
		}
		return new BvbMcaResponse(statusMessage, status);
	}

}
