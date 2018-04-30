package main.java.es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemRemote extends Remote{

	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			, String bankingAccount, int age, int telephoneNumber, String email, String country, String residence, int postalCode) throws RemoteException;
	public boolean logIn(String UserID, String Password) throws RemoteException;
	public String forgetPassword(String UserID, String email) throws RemoteException;
	public boolean changePassword(String UserID, String oldPassword, String newPassword) throws RemoteException;
	public boolean transaction(String userId, int userAccount, String targetId,int targetAccount, int amount, String desc, Date date) throws RemoteException;
	public boolean drawMoney(int amount) throws RemoteException;
	public List<AccountDTO> showAccountInfo() throws RemoteException;
	public List<UserDTO> showUserInfo() throws RemoteException;
	public UserDTO changeUserInfo(User u) throws RemoteException;
	
}

