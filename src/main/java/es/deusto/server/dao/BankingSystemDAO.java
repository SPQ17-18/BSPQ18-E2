package main.java.es.deusto.server.dao;

import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.datanucleus.api.jdo.JDOQuery;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAO implements IBankingSystemDAO{
	
	private PersistenceManagerFactory pmf;
	
	public BankingSystemDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	@Override
	public void newUser(User u) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try{
			tx.begin();
			System.out.println("Saving new user: "+u.toString());
			pm.makePersistent(u);
			tx.commit();
		} catch(Exception e){
			System.out.println("Error saving user: " + e.getMessage());
		} finally{
			if(tx != null && tx.isActive()){
				tx.rollback();
			}
			
			pm.close();
			
		}
	}
	
	@Override
	public boolean checkUser(String uID) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			System.out.println("- Retrieving users with client ID: "+ uID);			
			System.out.println(" -- CHECKING USERS ...");
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = (Transaction) pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery(User.class);
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i<users.size(); i++){
				if(users.get(i).getUserID().equals(uID)){
					return false;
				}
			}
			
		} catch (Exception e) {
			System.err.println(" $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return true;
		
	}


	@Override
	public boolean logIn(String uID, String password) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			System.out.println("- Retrieving users with client ID: "+ uID + ", Password: " + password);		
			System.out.println(" -- LOGIN IN THE SERVER --");
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + uID + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i < users.size(); i++){
				if(users.get(i).getPassword().equals(password)){
					return true;
				}
			}
			
		} catch (Exception e) {
			System.err.println(" $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}

	@Override
	public String forgetPassword(String uID, String email) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			System.out.println(" -- FORGETPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ uID + ", Email: " + email);					
			System.out.println(" -- RETURNING PASSWORD...");
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + uID + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i < users.size(); i++){
				if(users.get(i).getEmail().equals(email)){
					return users.get(i).getPassword();
				}
			}
			
		} catch (Exception e) {
			System.err.println(" $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return "ERROR";
	}

	@Override
	public boolean changePassword(String UserID, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx =  pm.currentTransaction();
		
		try {
			System.out.println(" -- CHANGEPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ UserID + ", Password: " + oldPassword);					
			System.out.println(" -- CHANGING PASSWORD...");
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (UserID.equals(users.getUserID()) && oldPassword.equals(users.getPassword())) {
					users.setPassword(newPassword);
					pm.makePersistent(users);
					//End the transaction
					tx.commit();
					return true;
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
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
	public List<Account> showAccountInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changeUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
