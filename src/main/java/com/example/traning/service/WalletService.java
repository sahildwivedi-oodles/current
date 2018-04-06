package com.example.traning.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.traning.domain.Register;
import com.example.traning.domain.Wallet;
import com.example.traning.dto.UserWalletDto;
import com.example.traning.repository.RegisterRepository;
import com.example.traning.repository.WalletRepository;
@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletrepository;
	@Autowired
	RegisterRepository registerrepository;
	
	
	// Create a new Wallet
	public Wallet createwallet(UserWalletDto userwalletdto) 
	{
		Register userData=registerrepository.findByUserid(userwalletdto.getUserid());
		System.out.println("----->"+userData);
		Wallet wall =new Wallet();
		Wallet will=null;
        for(Wallet walletModel:userData.getWall()) {
			
			if(walletModel.getWallet_type().equals((userwalletdto.getWallet_type())))
					{
					throw new NullPointerException("This Wallet type Already Exist");
					}
			else {
				System.out.println("----->");
				wall.setWallet_type(userwalletdto.getWallet_type());
				wall.setRegister(userData);
				will=walletrepository.save(wall);
			}
		}
		return  will;
	}


	public Wallet depositwallet(UserWalletDto userwalletdto) {
		
		Register userData=registerrepository.findByUserid(userwalletdto.getUserid());
		Set<Wallet> listmodel=userData.getWall();
		boolean flag=false;
		String newWalletType=userwalletdto.getWallet_type();
		Wallet mod = null;
        for(Wallet model:listmodel) {
			if(model.getWallet_type().equals(newWalletType)) {
				
				flag=true;
				Long newBalance=userwalletdto.getBalance()+ model.getBalance();
				Long newShadowbal=newBalance;
				model.setBalance(newBalance);
				model.setShadow_balance(newShadowbal);
				mod=walletrepository.save(model);
			}
		}
			if(flag==false) {
				 throw new NullPointerException("This Wallet Type Doesn't exist");
			}
		return mod;
	}


	
	
	public Wallet withdrawallet(UserWalletDto userwalletdto) {
		Register userData=registerrepository.findByUserid(userwalletdto.getUserid());
		Set<Wallet> listmodel=userData.getWall();
		boolean flag=false;
		Wallet  wall =null;
		String newWalletType=userwalletdto.getWallet_type();
		for(Wallet model:listmodel) 
		{
			if(model.getWallet_type().equals(newWalletType))
			{
			if(model.getBalance()>=userwalletdto.getBalance()) {
			flag=true;
		    long newBalnce=model.getBalance()-userwalletdto.getBalance();
		    model.setBalance(newBalnce);
		    wall= walletrepository.save(model);}
		    else 
		    {
			throw new UsernameNotFoundException("Not Enough Balance");
		    }
		  }
			
		}
		 if(flag==false){
			 throw new NullPointerException("This Wallet Type Doesn't exist");
		}	
		return wall;
		}
		
	}