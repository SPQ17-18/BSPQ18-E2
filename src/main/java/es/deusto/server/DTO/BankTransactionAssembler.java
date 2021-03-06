package main.java.es.deusto.server.DTO;


import java.util.ArrayList;
import java.util.List;

import main.java.es.deusto.server.data.BankTransaction;

public class BankTransactionAssembler {

	public List<BankTransactionDTO> assemble(List<BankTransaction> transactions) {
		List<BankTransactionDTO> BankTransactionDTO = new ArrayList<>();

		for (BankTransaction t : transactions) {
			BankTransactionDTO.add(new BankTransactionDTO( t.getTargetBankingAccount(), t.getAmount(), t.getDesc(), t.getHour(), t.getMinute(), t.getDay(), t.getMonth(), t.getYear()));
		}
		
		return BankTransactionDTO;
	}
}