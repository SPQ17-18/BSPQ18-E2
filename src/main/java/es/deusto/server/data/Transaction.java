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
	
}
