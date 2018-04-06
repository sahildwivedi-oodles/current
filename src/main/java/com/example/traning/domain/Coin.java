package com.example.traning.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "coin")
@EntityListeners(AuditingEntityListener.class)
public class Coin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long currencyid ;
	@Pattern(regexp = "[a-zA-z]*",message="Number and special charecter not accepted")
	@Size(min=3,max=20,message="lenght must be 2 to 20")
	private String coinName;
	private String symbol;
	private String initialSupply;
	private long price;
	
	
	public long getCurrencyid() {
		return currencyid;
	}
	public void setCurrencyid(long currencyid) {
		this.currencyid = currencyid;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getInitialSupply() {
		return initialSupply;
	}
	public void setInitialSupply(String initialSupply) {
		this.initialSupply = initialSupply;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
	
	

}
