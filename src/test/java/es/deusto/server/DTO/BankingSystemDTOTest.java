package test.java.es.deusto.server.DTO;

import static org.junit.Assert.*;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.server.DTO.AccountAssembler;
import main.java.es.deusto.server.DTO.AccountTypeAssembler;
import main.java.es.deusto.server.DTO.BankTransactionAssembler;
import main.java.es.deusto.server.DTO.UserAssembler;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

@PerfTest(invocations=5)
@Required(max=1200,average=250)

public class BankingSystemDTOTest {

	private static User user;
	private static User user2;
	private static Account account;
	private static Account account2;
	private static BankTransaction bt;
	private static BankTransaction bt2;
	private static AccountType at;
	private static AccountType at2;
	
	private static AccountAssembler as;
	private static BankTransactionAssembler bts;
	private static UserAssembler ua;
	private static AccountTypeAssembler atassembler;
	
	private static List<User> userList = new ArrayList<User>();
	private static List<Account> accountList = new ArrayList<Account>();
	private static List<BankTransaction> BankTransactionList = new ArrayList<BankTransaction>();
	private static List<AccountType> accountTypeList = new ArrayList<AccountType>();
	
	@BeforeClass
	public static void setUpClass() {
		//USER
		user = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "Bilbao", 01011);
		user2 = new User("9281281Y", "Password34", "Raul", "Plano", "Huki", "17/08/1969", 688273821, "Raul@gmail.es", "Spain", "Bilbao", 01011);
		
		//ACCOUNT
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		
		account = new Account (user.getUserID() + timeStamp, hour, minute, day, month, year, 0, "Young Account");
		account2 = new Account (user2.getUserID() + timeStamp, hour, minute, day, month, year, 0, "Young Account");

		//BANK TRANSACTION
		bt = new BankTransaction("8921UDSANNCAJDKALZ", account.getAccountID(), account2.getAccountID(), 100, "TRANSACTION TO", hour, minute, day, month, year);
		bt2 = new BankTransaction("OKED129ENDJANSKCXAMZ", account2.getAccountID(), account.getAccountID(), 140, "TRANSACTION TO", hour, minute, day, month, year);
	
		//ACCOUNT TYPE
		at = new AccountType("Young Account", "5% of discount in drawing money.");
		at2 = new AccountType("Elderly Account", "1% of discount in account transactions and 5% discount in Eroski.");
		
		//LISTS
		userList.add(user);
		userList.add(user2);
	
		accountList.add(account);
		accountList.add(account2);
		
		BankTransactionList.add(bt);
		BankTransactionList.add(bt2);
		
		accountTypeList.add(at);
		accountTypeList.add(at2);
		
		//ASSEMBLERS
		as = new AccountAssembler();
		bts = new BankTransactionAssembler();
		ua = new UserAssembler();
		atassembler = new AccountTypeAssembler();
	}
	
	@Test
	public void testAssembler() {
		//User assembler
		assertEquals(ua.assemble(userList).get(0).getName(), user.getName());
		assertEquals(ua.assemble(userList).get(1).getSurName1(), user2.getSurName1());
		
		//Account assembler
		assertEquals(as.assemble(accountList).get(0).getTotalAmount(), account.getTotalAmount());
		assertEquals(as.assemble(accountList).get(1).getDay(), account2.getDay());
		
		//BankTransaction
		assertEquals(bts.assemble(BankTransactionList).get(0).getAmount(), bt.getAmount());
		assertEquals(bts.assemble(BankTransactionList).get(1).getDay(), bt2.getDay());
		
		//AccountType
		assertEquals(atassembler.assemble(accountTypeList).get(0).getAccountType(), at.getAccountType());
		assertEquals(atassembler.assemble(accountTypeList).get(1).getAccountType(), at2.getAccountType());
	}
}