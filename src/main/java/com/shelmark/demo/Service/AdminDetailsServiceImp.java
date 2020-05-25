package com.shelmark.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shelmark.demo.Entity.Admin;
import com.shelmark.demo.Entity.Permission;

public class AdminDetailsServiceImp implements UserDetailsService {
	@Autowired
	private AdminService adminService;
	public final static String ROLE_PREFIX = "ROLE_";// Spring Security 4
	public final static String PERMISSION_AUTHENTICATED = "AUTH";

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Admin admin = adminService.findByUserName(userName);
		Collection<GrantedAuthority> authorities = new

		ArrayList<GrantedAuthority>();

		try {
			admin = adminService.findByUserName(userName);
			if (admin == null) {
				return null;
			}
			GrantedAuthority role = new SimpleGrantedAuthority(ROLE_PREFIX

					+ PERMISSION_AUTHENTICATED);// required to
// login
			authorities.add(role);
			if (admin.getPermissions() != null &&

					admin.getPermissions().size() > 0) {

				List<Permission> permissions = admin.getPermissions();
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

				userName, admin.getPassword(), authorities);
		return secUser;
	}
}
