package com.example.traning.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wallet")
@EntityListeners(AuditingEntityListener.class)
public class Wallet {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wallet_id;
	private long balance=0;
	private long shadow_balance=0;
	private String wallet_type="FIAT";
	
	
	//======================Changes=====================
	
	
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="user_wallet_fk")
	@JsonIgnore
	private Register register;
	
	
	
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	
	//===========================================
	public long getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(long wallet_id) {
		this.wallet_id = wallet_id;
	}
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getShadow_balance() {
		return shadow_balance;
	}
	public void setShadow_balance(long shadow_balance) {
		this.shadow_balance = shadow_balance;
	}
	public String getWallet_type() {
		return wallet_type;
	}
	public void setWallet_type(String wallet_type) {
		this.wallet_type = wallet_type;
	}
	

}
