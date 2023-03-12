package com.interview.app.ws.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "Missing first name")    //validate post request not null
    @Size(min = 4, message = "first name must be 4 chars")
    private String firstName;

    @NotNull(message = "Missing last name")
    @Size(min = 4, message = "last name must be 4 chars")
    private String lastName;

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


}
