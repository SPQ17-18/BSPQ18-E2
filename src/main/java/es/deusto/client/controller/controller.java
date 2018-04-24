package main.java.es.deusto.client.controller;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import main.java.es.deusto.client.GUI.GUI_MAIN;
import main.java.es.deusto.client.remote.RMIServiceLocator;

public class controller {
	
	private static RMIServiceLocator rsl;
	private static controller c;
	
	public static void main(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		newUser();
		new GUI_MAIN(c);
	}
	
	//ALL THE OPERATIONS THAT CAN BE DONE BY THE USER
	
	public static boolean newUser(){
		try{
			if(rsl.getService().newUser("78128D", "PAC", "XAB", "GAR", "MAR", "123213182", "DSDA", 19, 76361623, "DDSADAS", "DFAS", "residenc", 2) == false){
				JOptionPane.showMessageDialog(null, "New USER could not be created. There is already a USER with the same ID!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "New USER successfully created!");
			}
		} catch(Exception e){
    			System.out.println("$ Error creating a new USER: " + e.getMessage());
    	}
		
		return true;
	}
	
	public static boolean logIn(String userID, String password){
		try{
			if(rsl.getService().logIn(userID, password) == false){
				JOptionPane.showMessageDialog(null, "LOGIN failed!! Incorrect information!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "Successful LOGIN !! Correct information!");
			}
		} catch(Exception e){
			System.out.println("$ Error in the login: " + e.getMessage());
		}
		
		return true;
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

