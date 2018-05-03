package test.java.es.deusto.server.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.data.Account;
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
		//Check if User exist
		assertEquals(dao.checkUser(user.getUserID()), true);
		assertEquals(dao.checkUser(user2.getUserID()), true);
		
		//New User
		dao.newUser(user);
		dao.newUser(user2);
		
		//User login
		assertEquals(dao.logIn(user.getUserID(), user.getPassword()), true);
		
		//Show user information RETURN A USER
		List<User> listUser = dao.showUserInfo();

		assertEquals(listUser.get(0).getName(), user.getName());
		assertEquals(listUser.get(0).getSurName1(), user.getSurName1());
		
		//Forget password
		assertEquals(dao.forgetPassword(user.getUserID(), user.getEmail()), user.getPassword());
		
		//Change password
		assertEquals(dao.changePassword(user.getUserID(), user.getPassword(), "Secret"), true);
		
		//Change user information
		User u = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "98128381239FKKA", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "San Sebastian", 07061, null, null);
		dao.changeUserInfo(u);
	
	}
	
	@Test
	public void testUserMethods() {
		//THIS METHODS HAVE TO BE CHANGED
		//Insert Money
		//dao.insertMoney(user.getUserID(), 10000, "INSERT MONEY");
		
		//Draw Money
		//dao.drawMoney(user.getUserID(), 100, "DRAW MONEY");
		
		//Show account information RETURN A LIST
		dao.showAccountInfo();
	}
	
	@Test
	public void testUserTransactions() {
		//THIS METHODS HAVE SOME THINGS TO BE CHANGED
		
		//Transaction
		dao.transaction("98128381239FKKA", 100, "TRANSACTION TO");
		
		//Get Transactions LIST OF TRANSACTIONS
		dao.getBankTransactions();
	}
	
//	@Test
//	public void testDeleteDB() {
//		// Delete all Users from the DB
//		dao.deleteAllUsers();
//	}
}
