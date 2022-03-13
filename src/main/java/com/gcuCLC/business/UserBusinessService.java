package com.gcuCLC.business;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcuCLC.data.UserDataService;
import com.gcuCLC.model.gcuCLCuserDetails;

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
 * 1. Service - User Business Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Service
public class UserBusinessService implements UserDetailsService {

	@Autowired
	private UserDataService userDataService;
	
	/**
	 * No Args Constructor
	 */
	public UserBusinessService() {

	}
	
	/**
	 * Method to Auto Inject User Data Service
	 * @param userDataService - Auto Injected User Data Service
	 */
	public UserBusinessService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@Override
	/**
	 * Custom Method of the UserDetails loadUserByUsername Class that allows the program
	 * to pass user session data other than username and password only
	 * @param username - Session Data is tied to Username
	 * @return gcuCLCuserDetails - Stores user data of specific user during session
	 */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gcuCLC.entity.UserEntity user = userDataService.findByUsername(username);
        //List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that email");
        }
         
        return new gcuCLCuserDetails(user);
    }
	
}
