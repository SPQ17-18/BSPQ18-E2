package main.java.server.dao;

import main.java.server.data.User;

public interface IUserDAO {
	void storeUser(User u);
	User retrieveUser(String login);
	void updateUser(User u);

}
