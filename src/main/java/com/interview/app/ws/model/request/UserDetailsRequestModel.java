package com.interview.app.ws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {


    @NotNull(message = "Missing first name")    //validate post request not null
    @Size(min = 4, message = "first name must be 4 chars")
    private String firstName;
    @NotNull(message = "Missing last name")
    @Size(min = 4, message = "last name must be 4 chars")
    private String lastName;
    @NotNull(message = "Missing password ")
    @Size(min = 8,max = 16, message = "min 8 max 16") //validate size, min, max
    private String password;
    @NotNull(message = "Missing email ")
    @Email(message = "not a valid email")   //validate email type
    private String email;

    public UserDetailsRequestModel(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
