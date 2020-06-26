package com.shelmark.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Entity.Permission;

public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UserService userService;
	public final static String ROLE_PREFIX = "ROLE_";// Spring Security 4
	public final static String PERMISSION_AUTHENTICATED = "";

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userService.findByUserName(userName);
		Collection<GrantedAuthority> authorities = new

		ArrayList<GrantedAuthority>();

		try {
			user = userService.findByUserName(userName);
			if (user == null) {
				return null;
			}
			GrantedAuthority role = new SimpleGrantedAuthority(ROLE_PREFIX

					+ PERMISSION_AUTHENTICATED);// required to
// login
			authorities.add(role);
			if (user.getPermissions() != null &&

					user.getPermissions().size() > 0) {

				Set<Permission> permissions = user.getPermissions();
				for (Permission permission : permissions) {
					GrantedAuthority auth = new SimpleGrantedAuthority(ROLE_PREFIX + permission.getPermissionName());

					authorities.add(auth);
				}
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found.");
		}
		org.springframework.security.core.userdetails.User secUser = new

		org.springframework.security.core.userdetails.User(

				userName, user.getPassword(), authorities);
		return secUser;
	}
}
