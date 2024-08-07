package com.bvb.digitaltouch.service;

import java.util.List;


import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dto.PaymentDto;


public interface PaymentService {
	
	public abstract List<PaymentDto> getAllPayment()throws BvbMcaException;
	
	public abstract void deletePayment(Integer paymentId)throws BvbMcaException;
	
	public abstract void createPayment(PaymentDto paymentDto,Integer billId)throws BvbMcaException;

}
