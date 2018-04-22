package main.java.es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.dao.IBankingSystemDAO;

public class BankingSystemRemote extends UnicastRemoteObject implements IBankingSystemRemote {

	private static final long serialVersionUID = 1L;
	
	private IBankingSystemDAO dao;
	
	public BankingSystemRemote () throws RemoteException{
		dao = new BankingSystemDAO();
	}

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
	public boolean transaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drawMoney() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AccountDTO> showAccountInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO showUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO changeUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
