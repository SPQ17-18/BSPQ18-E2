package main.java.es.deusto.server.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.es.deusto.server.data.AccountType;

public class AccountTypeAssembler {
	
	public List<AccountTypeDTO> assemble(List<AccountType> accountType) {
		List<AccountTypeDTO> AccountTypeDTO = new ArrayList<>();

		for (AccountType at : accountType) {
			AccountTypeDTO.add(new AccountTypeDTO(at.getAccountType(), at.getDescription()));
		}
		
		return AccountTypeDTO;
	}
}