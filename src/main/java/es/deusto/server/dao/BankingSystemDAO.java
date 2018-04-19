package main.java.es.deusto.server.dao;

import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAO implements IBankingSystemDAO{

	@Override
	public boolean newUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logIn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String forgetPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transaction(String user1DNI, String user2DNI, int amount, String desc) {
		
		return false;
	}

	@Override
	public boolean drawMoney() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> showAccountInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changeUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
