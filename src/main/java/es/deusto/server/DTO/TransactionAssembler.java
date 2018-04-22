package main.java.es.deusto.server.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.es.deusto.server.data.Transaction;

public class TransactionAssembler {
	
	public List<TransactionDTO> assemble(List<Transaction> transactions) {
		List<TransactionDTO> transactionsDTO = new ArrayList<>();

		for (Transaction t : transactions) {
			transactionsDTO.add(new TransactionDTO(t.getDniUser1(),t.getDniUser2(),t.getAmount(),t.getDate(),t.getDesc()));
		}
		
		return transactionsDTO;
	}
}