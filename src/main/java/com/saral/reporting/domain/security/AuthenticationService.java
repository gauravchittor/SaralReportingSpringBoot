package com.saral.reporting.domain.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saral.reporting.DAO.LoginDAO;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private LoginDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Object[]> values = userDAO.getUserInfo(username);

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (Object[] result : values) {

			String sign_role = (String) result[9];

			authorities.add(new SimpleGrantedAuthority("ROLE_"+sign_role));

		}
System.out.println(authorities);
		Object[] l1 = values.get(0);

		UserDetails ud = new User((String) l1[0], (String) l1[10], authorities);
		return ud;

	}
}
