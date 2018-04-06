package com.example.traning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.traning.domain.Wallet;
import com.example.traning.dto.UserWalletDto;
import com.example.traning.service.WalletService;
import com.example.traning.utill.CustomExceptionhandler;

@RestController
//@RequestMapping("/tranapi")
public class WalletController 
{
	
	
	@Autowired
	WalletService walletservice;
	
	// Create a new Wallet
	  //save all data
    @RequestMapping(value="/addwallet",method=RequestMethod.POST)
	public ResponseEntity<Object> createwallet(@Valid @RequestBody UserWalletDto userwalletdto) {
    	Wallet obj=null;
    	if(userwalletdto.getUserid()==0)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "UserId can't be null",obj);
    	}
    	else if(userwalletdto.getWallet_type().isEmpty())
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "wallet type can't be null",obj);
    	}
    	else {
  
    	try {
    		System.err.println("----------try------------");
    	obj= walletservice.createwallet(userwalletdto);
            }
    	catch(Exception e) {
    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
    	}
    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"messsage suceessfuly", obj);
    	} 
    }
    
   //Deposit into wallet
    @RequestMapping(value="/depositamount",method=RequestMethod.POST)
    public ResponseEntity<Object> deposit(@Valid @RequestBody UserWalletDto userwalletdto) {
    	Wallet obj=null;
    	if(userwalletdto.getUserid()==0)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "UserId can't be null",obj);
    	}
    	else if(userwalletdto.getWallet_type().isEmpty())
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "wallet type can't be null",obj);
    	}
    	else if(userwalletdto.getBalance()==0)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Balance can't be null",obj);
    	}
    	else {
  
    	try {
    	obj= walletservice.depositwallet(userwalletdto);
            }
    	catch(Exception e) {
    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
    	}
    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"messsage suceessfuly", obj);
    	} 
    }
    
    
  //withdraw into wallet
    @RequestMapping(value="/withdrawamount",method=RequestMethod.POST)
    public ResponseEntity<Object> withdrw(@Valid @RequestBody UserWalletDto userwalletdto) {
    	Wallet obj=null;
    	if(userwalletdto.getUserid()==0)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "UserId can't be null",obj);
    	}
    	else if(userwalletdto.getWallet_type().isEmpty())
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "wallet type can't be null",obj);
    	}
    	else if(userwalletdto.getBalance()==0)
    	{
    		return CustomExceptionhandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Balance can't be null",obj);
    	}
    	else {
  
    	try {
    	obj= walletservice.withdrawallet(userwalletdto);
            }
    	catch(Exception e) {
    		return CustomExceptionhandler.generateResponse(HttpStatus.OK, false,e.getMessage(), obj);
    	}
    	return CustomExceptionhandler.generateResponse(HttpStatus.OK, true,"messsage suceessfuly", obj);
    	} 
    }

}
