package test.java.es.deusto.server.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAOTest {
	
	private static BankingSystemDAO dao;
	private static User user;
	private static User user2;
	
	@BeforeClass
	public static void setUpClass() {
		dao = new BankingSystemDAO();
		user = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "98128381239FKKA", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "Bilbao", 01011, null, null);
		user2 = new User("9281281Y", "Password34", "Raul", "Plano", "Huki", "213421892S21FCC", "17/08/1969", 688273821, "Raul@gmail.es", "Spain", "Bilbao", 01011, null, null);
		
		// Delete all Users from the DB
		dao.deleteAllUsers();
	}
	
	
	@Test
	public void testUser() {
		//New User
		dao.newUser(user);
		dao.newUser(user2);
		
		//User login
		dao.logIn(user.getUserID(), user.getPassword());
		
		//Forget password
		dao.forgetPassword(user.getUserID(), user.getEmail());
		
		//Change password
		dao.changePassword(user.getUserID(), user.getPassword(), "Secret");
		
		//Change user information
		User u = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "98128381239FKKA", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "San Sebastian", 07061, null, null);
		dao.changeUserInfo(u);
		
		//Show user information RETURN A USER
		dao.showUserInfo();
	}
	
	@Test
	public void testUserMethods() {
		//Insert Money
		dao.insertMoney(user.getUserID(), 10000, "INSERT MONEY");
		
		//Draw Money
		dao.drawMoney(user.getUserID(), 100, "DRAW MONEY");
		
		//Show account information RETURN A LIST
		dao.showAccountInfo();
	}
	
	@Test
	public void testUserTransactions() {
		//Transaction
		dao.transaction("98128381239FKKA", 100, "TRANSACTION TO");
		
		//Get Transactions LIST OF TRANSACTIONS
		dao.getBankTransactions();
	}
}
