package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;

import com.bvb.digitaltouch.dto.BillDto;

import com.bvb.digitaltouch.modules.Bill;



public class BillUtil {
	public static BillDto convertBillEntityToDto(Bill bills) {
		BillDto dto= new BillDto();
		BeanUtils.copyProperties(bills, dto);
		return dto;
	}
	
	
	public static Bill convertBillDtoToEntity(BillDto dto) {
		Bill bills = new Bill();
		BeanUtils.copyProperties(dto, bills);
		return bills;
	}


	

	

}
