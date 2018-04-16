package main.java.es.deusto.server.DTO;

public class AccountDTO {
	
	private int hour;
	private int minute;
	private int day;
	private int month;
	private int year;
	private int amount;
	
	//CONSTRUCTOR
	public AccountDTO(int hour, int minute, int day, int month, int year, int amount) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.amount = amount;
	}

	//GETTERS AND SETTERS
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

