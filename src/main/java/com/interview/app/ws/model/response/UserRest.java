package com.interview.app.ws.model.response;

import java.util.Map;

public class UserRest {


    private String firstName;
    private String lastName;
    private String userId;
    private String email;
    public UserRest(String firstName, String lastName, String userId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
