package com.interview.app.ws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service    //to create instance of utils class
public class Utils {

    public String generateUserId()
    {
        return UUID.randomUUID().toString();
    }
}
