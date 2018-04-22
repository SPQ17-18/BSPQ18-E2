package main.java.es.deusto.server.DTO;

import java.sql.Date;

import javax.jdo.annotations.PrimaryKey;

public class TransactionDTO {

	private String dniUser1;
	private String dniUser2;
	private float amount;
	private String desc;
	private Date date;

	public TransactionDTO(String dniUser1, String dniUser2, float amount, Date date, String desc) {
		super();
		this.dniUser1 = dniUser1;
		this.dniUser2 = dniUser2;
		this.amount = amount;
		this.desc = desc;
		this.date = date;
	}

	public String getDniUser1() {return dniUser1;}
	public void setDniUser1(String dniUser1) {this.dniUser1 = dniUser1;}

	public String getDniUser2() {return dniUser2;}
	public void setDniUser2(String dniUser2) {this.dniUser2 = dniUser2;}

	public float getAmount() {return amount;}
	public void setAmount(float amount) {this.amount = amount;}

	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}

	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	
	
}

	

