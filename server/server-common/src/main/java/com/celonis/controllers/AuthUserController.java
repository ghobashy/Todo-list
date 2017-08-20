package com.celonis.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthUserController {

    @RequestMapping("/oldUsers") /* Maps to all HTTP actions by default (GET,POST,..)*/
    public @ResponseBody
    String getUsers(){
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

    @RequestMapping("/Auth0Users")
    public @ResponseBody
    String getAuthUsers(){
        return "{\"users\":[{\"firstname\":\"Isaac\", \"lastname\":\"Newton\"}," +
                "{\"firstname\":\"Ada\",\"lastname\":\"Lovelace\"}]}";
    }
}
