package main.java.es.deusto.server.data;

import java.io.Serializable;
import java.sql.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable (detachable = "true")
public class Transaction implements Serializable{

	/**
	 * Transaction implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private String dniUser1;
	@PrimaryKey
	private String dniUser2;
	private float amount;
	private String desc;
	private Date date;
	
	public String getDniUser1(){return dniUser1;}
	public void setDniUser1(String dniUser1) {this.dniUser1 = dniUser1;	}
	
	public String getDniUser2() {return dniUser2;}
	public void setDniUser2(String dniUser2) {this.dniUser2 = dniUser2;}
	
	public float getAmount() {return amount;}
	public void setAmount(float amount) {this.amount = amount;}
	
	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}
	
	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	@Override
	public String toString() {
		return "Transaction [dniUser1=" + dniUser1 + ", dniUser2=" + dniUser2 + ", amount=" + amount + ", desc=" + desc
				+ ", date=" + date + "]";
	}
	
	
	
}
