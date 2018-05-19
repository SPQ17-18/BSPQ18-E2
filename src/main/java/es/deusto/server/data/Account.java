package main.java.es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;

@PersistenceCapable (detachable = "true")
public class Account {
	
	@PrimaryKey
	private String AccountID;
	
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	private int totalAmount;
	private String accountType;
	private String freezeAccount = "UNFREEZED"; 
	
	@Persistent(defaultFetchGroup="true")
	private User user;
	
	@Persistent(defaultFetchGroup = "true", mappedBy = "account", dependentElement = "true")
	@Join
	private List<BankTransaction> transactions = new ArrayList<>();
	
	public Account(String AccountID, String hour, String minute, String day, String month, String year, int totalAmount) {
		super();
		this.AccountID = AccountID;
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.totalAmount = totalAmount;
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String isFreezeAccount() {
		return freezeAccount;
	}
	
	public void setFreezeAccount(String freezeAccount) {
		this.freezeAccount = freezeAccount;
	}
	
	public String getAccountID() {
		return AccountID;
	}
	
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<BankTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addBankTransaction (BankTransaction BankTransaction) {
		this.transactions.add(BankTransaction);
		BankTransaction.setAccount(this);
	}
	
	
	
	@Override
	public String toString() {
		return "Account [AccountID=" + AccountID + ", hour=" + hour + ", minute=" + minute + ", day=" + day + ", month="
				+ month + ", year=" + year + ", totalAmount=" + totalAmount + ", accountType=" + accountType
				+ ", freezeAccount=" + freezeAccount + "]";
	}
	
	
}
