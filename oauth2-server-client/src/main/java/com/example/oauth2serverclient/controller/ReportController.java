package com.example.oauth2serverclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
public class ReportController {

    @RequestMapping("/hello")
    public String test(){
        return "Imnot a good boy";
    }

}
