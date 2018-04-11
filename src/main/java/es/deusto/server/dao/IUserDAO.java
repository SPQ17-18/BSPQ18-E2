package main.java.es.deusto.server.dao;

import main.java.es.deusto.server.data.User;

public interface IUserDAO {
	void storeUser(User u);
	User retrieveUser(String login);
	void updateUser(User u);

}
