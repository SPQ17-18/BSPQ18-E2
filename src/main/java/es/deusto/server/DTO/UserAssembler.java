package main.java.es.deusto.server.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.es.deusto.server.data.User;

public class UserAssembler {
	
	public List<UserDTO> assemble(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<>();

		for (User f : users) {
			usersDTO.add(new UserDTO(f.getId(),f.getDni(), f.getPassword(), f.getName(), f.getSurName1(), f.getSurName2(), f.getBankingAccount(), f.getAddress(), f.getBirthday()));
		}
		
		return usersDTO;
	}
}

