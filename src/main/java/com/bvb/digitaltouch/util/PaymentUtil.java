package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;

import com.bvb.digitaltouch.dto.PaymentDto;
import com.bvb.digitaltouch.modules.Payment;




public class PaymentUtil {
	
	public static PaymentDto convertPaymentEntityToDto(Payment payment ) {
		PaymentDto dto=new PaymentDto();
		BeanUtils.copyProperties(payment, dto);
		return dto;
    }

	
	
	public static Payment convertPaymentDtoToEntity(PaymentDto dto)
	{
		Payment payment=new Payment();
		BeanUtils.copyProperties(dto,payment);
		
		return payment;
	}

}
