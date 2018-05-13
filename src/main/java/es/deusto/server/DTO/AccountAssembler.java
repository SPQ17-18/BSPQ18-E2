package main.java.es.deusto.server.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.es.deusto.server.data.Account;

public class AccountAssembler {
	
	public List<AccountDTO> assemble(List<Account> accounts) {
		List<AccountDTO> AccountDTO = new ArrayList<>();

		for (Account a : accounts) {
			AccountDTO.add(new AccountDTO(a.getAccountID(), a.getHour(), a.getMinute(), a.getDay(), a.getMonth(), a.getYear(), a.getTotalAmount(), a.getAccountType(), a.isFreezeAccount()));
		}
		
		return AccountDTO;
	}
}
