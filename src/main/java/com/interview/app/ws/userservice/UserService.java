package com.interview.app.ws.userservice;

import com.interview.app.ws.model.request.UserDetailsRequestModel;
import com.interview.app.ws.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);

}
