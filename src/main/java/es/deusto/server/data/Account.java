package main.java.es.deusto.server.data;

public class Account {
	
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	private int amount;
	private String des;
	
	public Account(String hour, String minute, String day, String month, String year, int amount, String des) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.amount = amount;
		this.des = des;
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
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
	
}
