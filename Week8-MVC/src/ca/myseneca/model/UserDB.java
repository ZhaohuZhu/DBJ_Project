package ca.myseneca.model;

public class UserDB {

    public static boolean CkeckUser(User user) {
    	//TODO: Modify this code that check the user from the database
    	boolean ok = false;
    	if ("wsong@myseneca.ca".equals(user.getEmail()) 
    		  && "password".equals(user.getPassword())) {
    		ok = true;
    	}
    	return ok;
    }
}
