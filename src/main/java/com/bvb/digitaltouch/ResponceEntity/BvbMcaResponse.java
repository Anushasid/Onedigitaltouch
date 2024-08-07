package com.bvb.digitaltouch.ResponceEntity;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class BvbMcaResponse extends ResponseEntity<Object> {
	
	public BvbMcaResponse(Object body,HttpStatusCode status) {
		super(body,status);
		
	}
}
