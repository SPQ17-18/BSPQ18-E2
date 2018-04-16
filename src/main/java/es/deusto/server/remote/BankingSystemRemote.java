package main.java.es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankingSystemRemote extends UnicastRemoteObject implements IBankingSystemRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankingSystemRemote () throws RemoteException{
		
	}
}
