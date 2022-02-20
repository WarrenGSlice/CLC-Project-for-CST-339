package com.gcuCLC.controller;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Home Controller sets domain to root and redirects to index
@Controller
public class HomeController {

    // Show Home page.
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/loggedIn")
    public String loggedIn() {
    	return "index";
    }
    
    @RequestMapping("/trial")
    public String tryMe() {
    	return "trial";
    }

}