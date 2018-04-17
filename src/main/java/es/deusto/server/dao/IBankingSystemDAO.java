package main.java.es.deusto.server.dao;

import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {

	public boolean newUser();
	public boolean logIn();
	public String forgetPassword();
	public boolean changePassword();
	public boolean transaction();
	public boolean drawMoney();
	public List<Account> showAccountInfo();
	public User showUserInfo();
	public User changeUserInfo();
}
