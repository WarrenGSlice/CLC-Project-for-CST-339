package com.gcuCLC.business;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcuCLC.data.UserDataService;
import com.gcuCLC.model.gcuCLCuserDetails;

@Service
public class UserBusinessService implements UserDetailsService {

	@Autowired
	private UserDataService userDataService;
	
	public UserBusinessService() {

	}
	
	public UserBusinessService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		UserEntity user = userDataService.findByUsername(username);
//		if(user!=null)
//		{
//			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//			authorities.add(new SimpleGrantedAuthority("USER"));
//			return new User(user.getUsername(), user.getPassword(), authorities);
//		}
//		else
//		{
//			throw new UsernameNotFoundException("username not found");
//		}
//	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gcuCLC.entity.UserEntity user = userDataService.findByUsername(username);
        //List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that email");
        }
         
        return new gcuCLCuserDetails(user);
    }
	
}
