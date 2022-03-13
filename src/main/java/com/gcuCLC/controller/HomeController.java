package com.gcuCLC.controller;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Controller - Home Controller
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Home Controller sets domain to root and redirects to index
@Controller
public class HomeController {

	/**
	 * Shows Home Page
	 * @return "index" (home-page)
	 */
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    /**
     * Shows Logged In Message
     * @return index - home page
     */
    @GetMapping("/loggedIn")
    public String loggedIn() {
    	return "index";
    }
    
    /**
     * Shows test page
     * @return trial - test only
     */
    @RequestMapping("/trial")
    public String tryMe() {
    	return "trial";
    }

}