package main.java.es.deusto.server.DTO;

import java.sql.Date;

public class UserDTO {

	int id = -1;	String password=null;
	String dni;
	String name;
	String surName1;
	String surName2;
	String bankingAccount;
	String address;
	Date birthday;
	
	
	//CONSTRUCTOR
	public UserDTO(int id,String dni, String password, String name, String surName1, String surName2, String bankingAccount,
			String address, Date birthday) {
		super();
		this.id = id;
		this.dni= dni;
		this.password = password;
		this.name = name;
		this.surName1 = surName1;
		this.surName2 = surName2;
		this.bankingAccount = bankingAccount;
		this.address = address;
		this.birthday = birthday;
		
	}

	//GETTERS AND SETTERS
	public int getUserID() {
		return id;
	}

	public void setUserID(int userID) {
		id = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName1() {
		return surName1;
	}

	public void setSurName1(String surName1) {
		this.surName1 = surName1;
	}

	public String getSurName2() {
		return surName2;
	}

	public void setSurName2(String surName2) {
		this.surName2 = surName2;
	}

	public String getBankingAccount() {
		return bankingAccount;
	}

	public void setBankingAccount(String bankingAccount) {
		this.bankingAccount = bankingAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAge() {
		return birthday;
	}

	public void setAge(Date birthday) {
		this.birthday = birthday;
	}

	public String getDNI(){return dni;}
	public void setDNI(String userDNI){this.dni = userDNI;}
	
	
}
