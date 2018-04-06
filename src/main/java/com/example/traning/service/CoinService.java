package com.example.traning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.traning.domain.Coin;
import com.example.traning.exception.UserNotFoundException;
import com.example.traning.repository.CoinRepository;
@Service
public class CoinService {
	
	@Autowired
	CoinRepository coinrepository;
	
	//================Curds Operations==========================
	
	
	public Coin createcoin(Coin coin) throws UserNotFoundException {
		Coin co=coinrepository.findByCoinName(coin.getCoinName());
		System.out.println("hello 2"+co);
		if(co!=null) {
			throw new UserNotFoundException("this coin already exist");
		}else {
			System.out.println("hello 3"+co);
			coinrepository.save(coin);
		
		}
		return coin;
	}

	 //*******************************************************************************************
	public List<Coin> getAllCoins() {
		List<Coin> lcoin= coinrepository.findAll();
		if(lcoin.isEmpty()) {
			throw new NullPointerException("Table is null");
		}else {
			return lcoin;
		}
	}
	 //*******************************************************************************************

	public Coin updatecoin(Long currencyid,Coin coin ) {
		Coin coinref =coinrepository.findByCurrencyid(currencyid);
		if(coinref!=null) {
		coinref.setCoinName(coin.getCoinName());
		coinref.setInitialSupply(coin.getInitialSupply());
		coinref.setSymbol(coin.getSymbol());
		coinref.setPrice(coin.getPrice());
		Coin CoinObj=coinrepository.save(coinref);
		return CoinObj;	
		}else
		{
			throw new NullPointerException("Id doen't be exist");
		}
	}

	 //*******************************************************************************************
	public ResponseEntity<?> deletecoin(Long currencyid) {
		Coin coin=coinrepository.findByCurrencyid(currencyid);
		coinrepository.delete(coin);
		return ResponseEntity.ok().build();
	}

	 //*******************************************************************************************
	public Coin getDataById(Long currencyid) {
		 Coin col=coinrepository.findByCurrencyid(currencyid);
		 if(col!=null)
		 {
			return col; 
		 }
		 else {
			 throw new NullPointerException("Id doen't be exist");
		 }
	}
	
	
	//================Curds Operations==========================
	
}
