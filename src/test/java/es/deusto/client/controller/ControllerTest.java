package test.java.es.deusto.client.controller;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.User;

public class ControllerTest {
	
	private static User user;
	private static controller c;
	private static Account a;
	private static AccountType at;
	
	@BeforeClass
	public static void setUpClass() {
		user = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "Bilbao", 01011);
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		
		a = new Account (user.getUserID() + timeStamp, hour, minute, day, month, year, 0);
		
		at = new AccountType("Young Account", "5% of discount in drawing money.");
	}
	
	@Test
	public void testController() {
		fail("Not yet implemented");
	}

}
