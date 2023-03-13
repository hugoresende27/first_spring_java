package com.interview.app.ws.userservice.implementations;

import com.interview.app.ws.model.request.UserDetailsRequestModel;
import com.interview.app.ws.model.response.UserRest;
import com.interview.app.ws.shared.Utils;
import com.interview.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service    //to use @autowired inject dependency
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl()
    {
    }

    @Autowired
    public UserServiceImpl(Utils utils)
    {
        this.utils = utils;
    }
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest user = new UserRest(
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getPassword(),
                userDetails.getEmail());

//        String userId = UUID.randomUUID().toString();
        String userId = utils.generateUserId();
        user.setUserId(userId);

        if (this.users == null) this.users = new HashMap<>();
        this.users.put(userId,user);

        return user;
    }
}
