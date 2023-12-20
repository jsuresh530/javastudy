package com.solid.principles.singleresp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {
	//Store used by controller
    private Store store = new Store();

    //Single responsibility principle says the class is responsible for only single work.
    //Create a new user
    public String createUser(String userJson) throws IOException {

        UserPersistenceService persistenceService = new UserPersistenceService ();
        ObjectMapper mapper = new ObjectMapper();
        
        User user = mapper.readValue(userJson, User.class);

        final boolean validate = new UserValidator ().validateUser (user);
        if(!validate) {
            return "ERROR";
        }

        persistenceService.saveUser (user);

        return "SUCCESS";
    } 



}