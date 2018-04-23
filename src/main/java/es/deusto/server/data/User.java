package main.java.es.deusto.server.data;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

import java.util.ArrayList;

@PersistenceCapable (detachable = "true")
public class User implements Serializable {
	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private String UserID;	
	private String password;
	private String name;
	private String surName1;
	private String surName2;
	private String bankingAccount;
	private String address;
	private int age;
	private int telephoneNumber;
	private String email;
	private String country;
	private String residence;
	private int postalCode;
	
	@Persistent(defaultFetchGroup="true")
	private List<Account> accounts = new ArrayList<>();
	
	public User(String userID, String password, String name, String surName1, String surName2, String bankingAccount,
			String address, int age, int telephoneNumber, String email, String country, String residence,
			int postalCode, List<Account> accounts) {
		super();
		UserID = userID;
		this.password = password;
		this.name = name;
		this.surName1 = surName1;
		this.surName2 = surName2;
		this.bankingAccount = bankingAccount;
		this.address = address;
		this.age = age;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.country = country;
		this.residence = residence;
		this.postalCode = postalCode;
		this.accounts = accounts;
	}

	//GETTERS AND SETTERS
	public String getUserID() {
		return UserID;
	}
	
	public void setUserID(String userID) {
		UserID = userID;
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
	
	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", password=" + password + ", name=" + name + ", surName1=" + surName1
				+ ", surName2=" + surName2 + ", bankingAccount=" + bankingAccount + ", address=" + address + ", age="
				+ age + ", postalCode=" + postalCode + "]";
	}
	
}

