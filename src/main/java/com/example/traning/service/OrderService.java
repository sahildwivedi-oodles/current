package com.example.traning.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.traning.domain.Order;
import com.example.traning.domain.Register;
import com.example.traning.repository.OrderRepository;
import com.example.traning.repository.RegisterRepository;
@Service
public class OrderService {
	@Autowired
	OrderRepository orderrepository;
	
	@Autowired
	RegisterRepository registerrepository;

	//===========================================================
	public Set<Order> getOrderById(Long userid) {
		Register greg=registerrepository.findByUserid(userid);
		Set<Order> orderList=greg.getOrder();
		Order gettingOrder = null;
		if(orderList.isEmpty()) {throw new NullPointerException("No any order present");}
		else {
			return orderList;
		}
		
	}
	
	
	//=============================================================
	

	public Order createbuyOrder(Order order) {
		Register userData=registerrepository.findByUserid(order.getUserid());
		if(userData==null) {
			throw new NullPointerException("User Doesn't exist");
		}
		else 
		{
			order.setOrderType("buy");
			order.setStatus("pending");
			order.setOrderCreatedOn(new Date());
			order.setRegister(userData);
			orderrepository.save(order);
		
		}
		return order;
	}
	
	
	//================================================================
	
	public Order createsellOrder(Order order) {
		Register userData=registerrepository.findByUserid(order.getUserid());
		if(userData==null) {
			throw new NullPointerException("User Doesn't exist");
		}
		else 
		{
			order.setOrderType("sell");
			order.setStatus("pending");
			order.setOrderCreatedOn(new Date());
			order.setRegister(userData);
			orderrepository.save(order);
		
		}
		return order;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public Order UpdateOrder(Integer orderId,
			Order RegDetails) {

		Order note = orderrepository.findByOrderId(orderId);
   if(note!=null)
   {
      note.setTradingAmount(RegDetails.getTradingAmount());
      note.setFee(RegDetails.getFee());
      note.setOrderType(RegDetails.getOrderType());
      note.setStatus(RegDetails.getStatus());
      note.setUserId(RegDetails.getUserId());
      note.setCoinId(RegDetails.getCoinId());

      Order updatedNote = orderrepository.save(note);
    
    return updatedNote;
    }
   else {
   	throw new NullPointerException("Id doen't be exist");
   }
    }
	*/
	
	
	
	
	/*public String deleteOrder( Integer orderId) {
	    Order note = orderrepository.findByOrderId(orderId);  
	    if(note!=null) {
	    	orderrepository.delete(note);
	    return "succesfully delete "+note.getOrderId()+" "+note.getOrderType();
	    
	    }
	    else {
	    return "User Doesnt exist";
	}
	    }
	*/
	
	
	/*
	public List<Order> getAllOrder() {
		List<Order> lorder= orderrepository.findAll();
		if(lorder.isEmpty()) {
			throw new NullPointerException("Table is null");
		}else {
			return lorder;
		}
	}*/
	
}
