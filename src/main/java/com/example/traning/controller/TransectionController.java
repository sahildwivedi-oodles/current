/*package com.example.traning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.traning.domain.Transaction;
import com.example.traning.service.TransectionService;
import com.example.traning.utill.CustomExceptionhandler;

@RestController
public class TransectionController {
	
	@Autowired
	TransectionService transectionservice;
	
	@RequestMapping(value="/transection",method=RequestMethod.GET)
	public ResponseEntity<Object> transection(){
		Transaction obj=null;
  		try {
  			obj= transectionservice.transfer();
  	            }
  	    	catch(Exception e) {
  	    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
  	    	}
  	    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"Transection done suceessfuly", obj);
    	
		
	}
	

}
*/