package com.interview.app.ws.ui.controller;

import com.interview.app.ws.model.response.UserRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;//import of CRUD annotations

import java.awt.*;

@RestController
@RequestMapping("users") //http://localhost:8081/users
public class UserController {

    @GetMapping     //care using required with primitive type cause error if not send, primitive not
    //initialized cant be converted to null //null pointer exception
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "50") int limit,
                           @RequestParam(value="sort", defaultValue = "desc" ,required = false) String sort)
    {
        return "page "+ page + " limit " + limit + " sort " + sort;
    }

    @GetMapping(path="/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE ,   //return XML
            MediaType.APPLICATION_JSON_VALUE})  //or return JSON
            //in request set Accept application/xml or application/json
    //annotation //url http://localhost:8081/users/userId GET
    public ResponseEntity getUser(@PathVariable String userId)
    {
        //        return new UserRest("Hugo","Resende","h@r.com",userId);
        if (userId.equals("bad")){
            return new ResponseEntity("BAD REQUEST TEST",HttpStatus.BAD_REQUEST);
        }
        UserRest user = new UserRest(userId+"firstName",userId+"lastName",userId,userId+"@"+userId+".com");
        return new ResponseEntity<UserRest>(user,HttpStatus.OK);

    }

    @PostMapping//annotation to be post request //url http://localhost:8081/users POST
    public String createUser()
    {
        return "create user was called";
    }

    @PutMapping//url http://localhost:8081/users PUT
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping//url http://localhost:8081/users DELETE
    public String deleteUser()
    {
        return "delete user was called";
    }



}
