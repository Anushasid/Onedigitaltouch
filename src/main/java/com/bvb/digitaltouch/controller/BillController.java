package com.bvb.digitaltouch.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.ResponceEntity.BvbMcaResponse;
import com.bvb.digitaltouch.dto.BillDto;
import com.bvb.digitaltouch.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService billService;

	Logger logger = LoggerFactory.getLogger(BillController.class);

	@GetMapping("/all")
	public BvbMcaResponse getAllBill() {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	String statusMessage = "";
    	try {
    		logger.info("Trying to read all bills");
    		List<BillDto> bills = billService.getAllBill();
    		status = HttpStatus.OK;
    		return new BvbMcaResponse(bills,status);
    	}catch(BvbMcaException e) {
    		statusMessage = "Error while reading all the bills;"+e.getMessage();
    	}catch(Exception e) {
    		e.printStackTrace();
			logger.error("Error while reading bills");
    		
    	}
    	return new BvbMcaResponse(statusMessage, status);
    }
	
	@PostMapping("/user-id/{userId}")
	public BvbMcaResponse createBill(@RequestBody BillDto bill,@PathVariable("userId") Integer userId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage = "";
		try {
			billService.createBill(bill, userId);
			status = HttpStatus.OK;
			statusMessage = "Bill created successfully. or Existing bills are given in logger";
		} catch (BvbMcaException e) {
			statusMessage = "Error while creating Bill; " + e.getLocalizedMessage();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new BvbMcaResponse(statusMessage, status);

	}

}
