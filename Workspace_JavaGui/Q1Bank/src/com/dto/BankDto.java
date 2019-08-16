package com.dto;

import java.util.Date;

public class BankDto {

	private String account;
	private String name;
	private String password;
	private int t_balance;
	private Date reg_date;//개설일
	
	private Date trade_date;//거래일자
	private String sender;//송금인
	private String message;//거래내용
	private int input; //들어온돈(입금)
	private int output;//나가는돈(출금)
	private int balance;//잔액
	
	public BankDto() {}

	public BankDto(String account, String name, String password, int t_balance, Date reg_date) {
		this.account = account;
		this.name = name;
		this.password = password;
		this.t_balance = t_balance;
		this.reg_date = reg_date;
	}

	public BankDto(String account, Date trade_date, String sender, String message, int input, int output, int balance) {
		this.account = account;
		this.trade_date = trade_date;
		this.sender = sender;
		this.message = message;
		this.input = input;
		this.output = output;
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getT_balance() {
		return t_balance;
	}

	public void setT_balance(int t_balance) {
		this.t_balance = t_balance;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
