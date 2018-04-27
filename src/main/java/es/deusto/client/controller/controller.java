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
		changePassword();
		new GUI_MAIN(c);
	}
	
	//ALL THE OPERATIONS THAT CAN BE DONE BY THE USER
	
	public static boolean newUser(){
		try{
			if(rsl.getService().newUser("78128D", "PAC", "XAB", "GAR", "MAR", "123213182", 19, 76361623, "DDSADAS", "DFAS", "residenc", 2) == false){
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
	
	public void forgetPassword(String UserID, String email){
		try{
			String pass = rsl.getService().forgetPassword(UserID, email);
			if(pass.equals("ERROR")){
				JOptionPane.showMessageDialog(null, "Incorrect information!! Please, fill the gaps again.");
			}
			else{
				JOptionPane.showMessageDialog(null, "Your password is: " + pass);
			}
		} catch(Exception e){
			System.out.println("$ Error in forgetPassword method: " + e.getMessage());
		}
	}
	
	public static void changePassword(){ //String UserID, String oldPassword, String newPassword
		try{
			if(rsl.getService().changePassword("78128D", "PAC", "CAT") == false){
				JOptionPane.showMessageDialog(null, "Incorrect information!! Please, fill the gaps again.");
			}
			else{
				JOptionPane.showMessageDialog(null, "Correct information! New password updated.");
			}
		} catch(Exception e){
			System.out.println("$ Error in changePassword method: " + e.getMessage());
		}
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

