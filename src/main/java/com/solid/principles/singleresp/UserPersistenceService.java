package com.solid.principles.singleresp;

public class UserPersistenceService {

    public void saveUser(User user){
        new Store ().store (user);
    }
	
}
