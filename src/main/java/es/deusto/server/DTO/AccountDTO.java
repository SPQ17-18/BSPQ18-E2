package main.java.es.deusto.server.DTO;

import java.io.Serializable;

import main.java.es.deusto.server.data.AccountType;

public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String AccountID;
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	private int totalAmount;
	private AccountType accountType;
	private boolean freezeAccount = true;
	
	public AccountDTO(String accountID, String hour, String minute, String day, String month, String year,
			int totalAmount, AccountType accountType, boolean freezeAccount) {
		super();
		AccountID = accountID;
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.totalAmount = totalAmount;
		this.accountType = accountType;
		this.freezeAccount = freezeAccount;
	}

	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
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

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public boolean isFreezeAccount() {
		return freezeAccount;
	}

	public void setFreezeAccount(boolean freezeAccount) {
		this.freezeAccount = freezeAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
