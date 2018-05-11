package main.java.es.deusto.server.DTO;

import java.io.Serializable;

public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	private int totalAmount;
	
	public AccountDTO(String hour, String minute, String day, String month, String year, int totalAmount) {
		super();
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
	
}
