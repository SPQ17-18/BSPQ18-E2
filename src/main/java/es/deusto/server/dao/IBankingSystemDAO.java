package main.java.es.deusto.server.dao;

import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {

	public void newUser(User u);
	public boolean checkUser(String uID);
	public boolean logIn(String uID, String password);
	public String forgetPassword(String UserID, String email);
	public boolean changePassword(String UserID, String oldPassword, String newPassword);
	public boolean transaction(String userId, int userAccount, String targetId,int targetAccount, int amount, String desc, Date date);
	public boolean insertMoney(int amount);
	public boolean drawMoney(int amount);
	public List<Account> showAccountInfo();
	public List<User> showUserInfo();
	public User changeUserInfo(User u);
}

