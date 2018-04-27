package main.java.es.deusto.server.dao;

import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {

	public void newUser(User u);
	public boolean checkUser(String uID);
	public boolean logIn(String uID, String password);
	public String forgetPassword(String UserID, String email);
	public boolean changePassword(String UserID, String oldPassword, String newPassword);
	public boolean transaction();
	public boolean drawMoney();
	public List<Account> showAccountInfo();
	public User showUserInfo();
	public User changeUserInfo();
}

