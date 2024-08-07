package com.bvb.digitaltouch.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dao.BillRepository;
import com.bvb.digitaltouch.dao.PaymentRepository;
import com.bvb.digitaltouch.dto.PaymentDto;
import com.bvb.digitaltouch.modules.Bill;
import com.bvb.digitaltouch.modules.Payment;
import com.bvb.digitaltouch.service.PaymentService;
import com.bvb.digitaltouch.util.PaymentUtil;


@Service
public class PaymentServiceImpl implements PaymentService{

	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	//Getmethod
	public List<PaymentDto> getAllPayment(){
		List<PaymentDto> listOfDtos = paymentRepository.findAll().stream().map(PaymentUtil::convertPaymentEntityToDto)
				.collect(Collectors.toList());
		return listOfDtos;
	}
	// Delete method
		@Override
		public void deletePayment(Integer paymentId)throws BvbMcaException  {
			boolean exists = paymentRepository.existsById(paymentId);

			if (!exists) {
				throw new BvbMcaException("payment with id " + paymentId + " does not exists");
			}
			paymentRepository.deleteById(paymentId);
		}

	
	public void createPayment(PaymentDto paymentDto,Integer billId)throws BvbMcaException{
			 Optional<Bill> bill = billRepository.findById(billId);
			 if(bill.isPresent()) {
				 logger.info("bill is present");
				 Bill bills = bill.get();
				 Payment payment = PaymentUtil.convertPaymentDtoToEntity(paymentDto);
				 payment.setBill(bills); 
				 paymentRepository.save(payment);
				 logger.info("Payment created successfully");
				 }
			 else {
					logger.info("Bill with bill Id {} is not present",billId);
					throw new BvbMcaException("Bill not found");
					
				}

		 }

	
		

}



