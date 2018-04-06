package com.example.traning.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.traning.domain.Order;
import com.example.traning.service.OrderService;
import com.example.traning.utill.CustomExceptionhandler;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	//==========================================================================================
	
	//get single data by id
  	@RequestMapping(value="/getorderbyuserid/{userid}",method=RequestMethod.GET)
  	public ResponseEntity<Object> getById(@PathVariable(value="userid") Long userid) {
  		Set<Order> obj=null;
  		if(userid==null)
  		{
  			return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "OrderId can't be null",obj);
  		}
  		else
  		{
  		try {
  	    	obj= orderservice.getOrderById(userid);
  	            }
  	    	catch(Exception e) {
  	    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
  	    	}
  	    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"Data Search  suceessfuly", obj);
  		}	
  	}
	
  //==========================================================================================
	
	
  	 //save all data by buy
    @RequestMapping(value="/createbuyorder",method=RequestMethod.POST)
	public ResponseEntity<Object> savebuyuser(@RequestBody Order order) {
    	Order obj=null;
    	if(order.getTradingAmount()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "tradingAmount can't be null",obj);
    	}
    	else if(order.getFee()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "fee can't be null",obj);
    	}
    	else if(order.getQuoteValue()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "quoteValue can't be null",obj);
    	}
    	else if(order.getCoinName().isEmpty())
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "coinName can't be null",obj);
    	}
    	else {
    	 
    	try {
    	obj= orderservice.createbuyOrder(order);
            }
    	catch(Exception e) {
    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
    	}
    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"messsage suceessfuly", obj);
    	}
      }
    
    
    
	//================================================================================================================
	
	
    //save all data by sell
    @RequestMapping(value="/createsellorder",method=RequestMethod.POST)
	public ResponseEntity<Object> saveselluser(@RequestBody Order order) {
    	Order obj=null;
    	if(order.getTradingAmount()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "tradingAmount can't be null",obj);
    	}
    	else if(order.getUserid()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "ID can't be null",obj);
    	}
    	else if(order.getFee()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "fee can't be null",obj);
    	}
    	else if(order.getQuoteValue()==null)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "quoteValue can't be null",obj);
    	}
    	else if(order.getCoinName().isEmpty())
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "coinName can't be null",obj);
    	}
    	else {
    	 
    	try {
    		obj= orderservice.createsellOrder(order);
            }
    	catch(Exception e) {
    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
    	}
    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"messsage suceessfuly", obj);
    	}
      }
	//==================================================================================================================
	
	
	
	
}	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
 
    
  	
  	/*
  	 @RequestMapping(value="/updateorder/{orderId}",method=RequestMethod.PUT)
     public ResponseEntity<?> updatedata(@PathVariable(value = "orderId") Integer orderId,
             @Valid @RequestBody Order RegDetails) {
  		Order obj=null;
  	   System.out.println("hello");
  	   try {
  	    	obj= orderservice.UpdateOrder(orderId,RegDetails);
  	        }
  	    	catch(Exception e) {
  	    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
  	    	}
  	   return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"Update suceessfuly", obj);
  	   
     }
     

     //delete data
     @RequestMapping(value="/deleteorder/{orderId}",method=RequestMethod.DELETE)
     public String deletedata(@PathVariable(value = "orderId") Integer orderId) {
 	  if(orderId!=null)
     	return orderservice.deleteOrder(orderId);
 	  else
 		  return "id is not exist";
     }
     
   //final all data 
     @RequestMapping(value="/getallorders",method=RequestMethod.GET)
     public ResponseEntity<Object> getAllCoin(){
     	List<Order> obj=null;
   		try {
   			obj= orderservice.getAllOrder();
   	            }
   	    	catch(Exception e) {
   	    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
   	    	}
   	    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"Table found suceessfuly", obj);
  
     }
     
     */
	
