package main.java.es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.UserDTO;

public interface IBankingSystemRemote extends Remote{

	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			, String bankingAccount, String address, int age, int telephoneNumber, String email, String country, String residence, int postalCode) throws RemoteException;
	public boolean logIn(String UserID, String Password) throws RemoteException;
	public String forgetPassword() throws RemoteException;
	public boolean changePassword() throws RemoteException;
	public boolean transaction() throws RemoteException;
	public boolean drawMoney() throws RemoteException;
	public List<AccountDTO> showAccountInfo() throws RemoteException;
	public UserDTO showUserInfo() throws RemoteException;
	public UserDTO changeUserInfo() throws RemoteException;
	
}

