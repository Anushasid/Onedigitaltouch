package com.bvb.digitaltouch.service;

import java.util.List;

import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dto.BillDto;


public interface BillService {
		
	public abstract List<BillDto> getAllBill()throws BvbMcaException;
	
	public abstract void createBill(BillDto bill,Integer userId) throws BvbMcaException;

	
	
	
		



}
