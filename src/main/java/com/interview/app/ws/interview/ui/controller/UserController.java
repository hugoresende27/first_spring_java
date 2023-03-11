package com.interview.app.ws.interview.ui.controller;

import org.springframework.web.bind.annotation.*;//import of CRUD annotations

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

    @GetMapping(path="/{userId}")
    //annotation //url http://localhost:8081/users/userId GET
    public String getUser(@PathVariable String userId)
    {
        return userId + " was called";
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
