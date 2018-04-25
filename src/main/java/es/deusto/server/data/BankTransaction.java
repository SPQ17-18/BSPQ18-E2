package main.java.es.deusto.server.data;

import java.util.Date;

public class BankTransaction {

	private String user1Dni;
	private String user2Dni;
	private int amount;
	private String desc;
	private Date date;
	
	public BankTransaction(String user1Dn1, String user2Dni, int amount, String desc, Date date) {
		super();
		this.user1Dni = user1Dn1;
		this.user2Dni = user2Dni;
		this.amount = amount;
		this.desc = desc;
		this.date = date;
	}
	
	//GETTERS AND SETTERS
	public String getUser1Dni() {return user1Dni;}
	public void setUser1Dni(String user1Dni) {this.user1Dni = user1Dni;}

	public String getUser2Dni() {return user2Dni;}
	public void setUser2Dni(String user2Dni) {this.user2Dni = user2Dni;}

	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}

	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}

	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	
}
