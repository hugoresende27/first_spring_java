package com.interview.app.ws.ui.controller;

import com.interview.app.ws.exeptions.UserServiceException;
import com.interview.app.ws.model.request.UpdateUserDetailsRequestModel;
import com.interview.app.ws.model.request.UserDetailsRequestModel;
import com.interview.app.ws.model.response.UserRest;

import com.interview.app.ws.userservice.UserService;
import com.interview.app.ws.userservice.implementations.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;//import of CRUD annotations

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http://localhost:8081/users
public class UserController {


    Map<String, UserRest> users;

    @Autowired  //to create an instance of UserService and inject also autowired in UserServiceImpl
    UserService userService;



    /** getUsers **************************************************************
     * //care using required with primitive type cause error if not send, primitive not
     * //initialized cant be converted to null //null pointer exception
     */
    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "50") int limit,
                           @RequestParam(value="sort", defaultValue = "desc" ,required = false) String sort)
    {
        return "page "+ page + " limit " + limit + " sort " + sort;
    }






    /** getUser **************************************************************
     *     //in request set Accept application/xml or application/json
     *     //annotation //url http://localhost:8081/users/userId GET
     */
    @GetMapping(path="/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE ,   //return XML
            MediaType.APPLICATION_JSON_VALUE})  //or return JSON
    public ResponseEntity getUser(@PathVariable String userId)
    {
        // handle exception with custom message
//         String firstName = null;
//         int firstNameLegth = firstName.length();
        /*
            <timestamp>2023-03-12T12:19:46.835+00:00</timestamp>
            <message>Cannot invoke "String.length()" because "firstName" is null</message>
         */
        //        return new UserRest("Hugo","Resende","h@r.com",userId);

//        if (true) throw new UserServiceException("A user service exception is thrown");
        if (userId.equals("bad")){
            return new ResponseEntity<>("BAD REQUEST TEST",HttpStatus.BAD_REQUEST);
        }

        if (this.users.containsKey(userId)){
            return new ResponseEntity<>(this.users.get(userId),HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found",HttpStatus.NO_CONTENT);
        }


    }




    /** createUser **************************************************************
    //In postman, Content-type to define type data content to send,
    //Accept to define type of data content returned
    //annotation to be post request //url http://localhost:8081/users POST
    // @Valid use to validate content send
    // server config to show errors (application.properties)
    //server.error.include-message=always
    //server.error.include-binding-errors=always
     */
    @PostMapping(
            consumes = {
                MediaType.APPLICATION_XML_VALUE ,   //consumes XML
                MediaType.APPLICATION_JSON_VALUE}, //or consumes JSON
            produces = {
                MediaType.APPLICATION_XML_VALUE ,   //return XML
                MediaType.APPLICATION_JSON_VALUE})  //or return JSON

    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
//        UserRest user = new UserRest(
//                userDetails.getFirstName(),
//                userDetails.getLastName(),
//                userDetails.getPassword(),
//                userDetails.getEmail());
//
//        String userId = UUID.randomUUID().toString();
//        user.setUserId(userId);
//
//        if (this.users == null) this.users = new HashMap<>();
//        this.users.put(userId,user);

//        UserRest user = new UserServiceImpl().createUser(userDetails);

        UserRest user = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(user,HttpStatus.OK);

    }


    /** updateUser **************************************************************.
     *     //url http://localhost:8081/users PUT
     */
    @PutMapping(path = "/{userId}" ,
            consumes = {
                MediaType.APPLICATION_XML_VALUE ,   //consumes XML
                MediaType.APPLICATION_JSON_VALUE}, //or consumes JSON
            produces = {
                MediaType.APPLICATION_XML_VALUE ,   //return XML
                MediaType.APPLICATION_JSON_VALUE})  //or return JSON)
    public UserRest updateUser(@PathVariable String userId,
                             @Valid @RequestBody UpdateUserDetailsRequestModel userDetails )
    {
        UserRest userUpdated = this.users.get(userId);
        userUpdated.setFirstName(userDetails.getFirstName());//get data from userDetails
        userUpdated.setLastName(userDetails.getLastName());

        this.users.put(userId,userUpdated);

        return  userUpdated;
    }





    /** deleteUser **************************************************************
     * //url http://localhost:8081/users DELETE
     */
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id)
    {
        this.users.remove(id);
        return ResponseEntity.noContent().build();
    }



}
