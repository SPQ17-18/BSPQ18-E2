package main.java.es.deusto.server.DTO;

import java.io.Serializable;
import java.util.Date;

public class BankTransactionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String targetBankingAccount;
	private int amount;
	private String desc;
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	
	
	public BankTransactionDTO( String targetBankingAccount, int amount, String desc, String hour,
			String minute, String day, String month, String year) {
		super();
		this.targetBankingAccount = targetBankingAccount;
		this.amount = amount;
		this.desc = desc;
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
	}


	public String getTargetBankingAccount() {
		return targetBankingAccount;
	}


	public void setTargetBankingAccount(String targetBankingAccount) {
		this.targetBankingAccount = targetBankingAccount;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}


	public String getMinute() {
		return minute;
	}


	public void setMinute(String minute) {
		this.minute = minute;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

}
