package main.java.es.deusto.client.controller;

import java.rmi.RemoteException;

import main.java.es.deusto.client.GUI.GUI_MAIN;
import main.java.es.deusto.client.remote.RMIServiceLocator;

public class controller {
	
	private static RMIServiceLocator rsl;
	private static controller c;
	

	public static void main(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		new GUI_MAIN(c);
	}
	
	//ALL THE OPERATIONS THAT CAN BE DONE BY THE USER
	
	public boolean newUser(){
		return false;
	}
	
	public boolean logIn(){
		return false;
	}
	
	public String forgetPassword(){
		return "";
	}
	
	public boolean changePassword(){
		return false;
	}
	
	public boolean transaction(){
		return false;
	}
	
	public boolean drawMoney(){
		return false;
	}
	
	public boolean showAccountInfo(){
		return false;
	}
	
	public boolean showUserInfo(){
		return false;
	}
	
	public boolean changeUserInfo(){
		return false;
	}
	
	
}

