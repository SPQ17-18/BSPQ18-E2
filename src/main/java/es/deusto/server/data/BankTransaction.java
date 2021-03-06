package main.java.es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

@PersistenceCapable (detachable = "true")
public class BankTransaction {
	
	@PrimaryKey
	private String BankTransactionID;
	
	private String sourceBankingAccount;
	private String targetBankingAccount;
	private int amount;
	private String desc;
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	
	@Persistent(defaultFetchGroup="true")
	private Account account;
	
	
	public BankTransaction(String BankTransactionID, String sourceBankingAccount, String targetBankingAccount, int amount, String desc, String hour,
			String minute, String day, String month, String year) {
		super();
		this.sourceBankingAccount = sourceBankingAccount;
		this.BankTransactionID = BankTransactionID;
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


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public String getBankTransactionID() {
		return BankTransactionID;
	}


	public void setBankTransactionID(String bankTransactionID) {
		BankTransactionID = bankTransactionID;
	}


	public String getSourceBankingAccount() {
		return sourceBankingAccount;
	}


	public void setSourceBankingAccount(String sourceBankingAccount) {
		this.sourceBankingAccount = sourceBankingAccount;
	}


	@Override
	public String toString() {
		return "BankTransaction [BankTransactionID=" + BankTransactionID + ", sourceBankingAccount="
				+ sourceBankingAccount + ", targetBankingAccount=" + targetBankingAccount + ", amount=" + amount
				+ ", desc=" + desc + ", hour=" + hour + ", minute=" + minute + ", day=" + day + ", month=" + month
				+ ", year=" + year + "]";
	}
	
	
}
