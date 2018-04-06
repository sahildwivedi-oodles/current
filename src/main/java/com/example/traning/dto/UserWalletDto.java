package com.example.traning.dto;

public class UserWalletDto {
	private long userid;
	private long balance;
	private String wallet_type;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getWallet_type() {
		return wallet_type;
	}
	public void setWallet_type(String wallet_type) {
		this.wallet_type = wallet_type;
	}

}
