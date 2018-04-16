package main.java.LogIn;

public class logIn 
{
	private User[] aUser = new User[4];
	
	public void createUser(){
		
		User p1 = new User("Pablo", "pablo");
		User p2 = new User("Asier", "asier");
		User p3 = new User("Xabier", "garcia");
		User p4 = new User("Philipp", "philipp");
		
		aUser[0] = p1;
		aUser[1] = p2;
		aUser[2] = p3;
		aUser[3] = p4;
		
		}
	
	public String login(String username, String password){
		
		createUser();
		
		for(int i = 0; i<aUser.length;i++){
			if(aUser[i].getUsername().equals(username)){
				if(aUser[i].getPassword().equals(password)){
					return "Login done successfully.";
				}
			}
		}
		return "Login could not be done.";
	}
}