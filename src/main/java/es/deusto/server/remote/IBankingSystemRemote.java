package main.java.es.deusto.server.remote;

import java.rmi.Remote;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.UserDTO;

public interface IBankingSystemRemote extends Remote{

	public boolean newUser();
	public boolean logIn();
	public String forgetPassword();
	public boolean changePassword();
	public boolean transaction();
	public boolean drawMoney();
	public List<AccountDTO> showAccountInfo();
	public UserDTO showUserInfo();
	public UserDTO changeUserInfo();
	
}
