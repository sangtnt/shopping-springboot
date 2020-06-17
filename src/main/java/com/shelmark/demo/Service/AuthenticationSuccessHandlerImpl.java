package com.shelmark.demo.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.shelmark.demo.SetupSession;
import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.UserRepository;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired UserService userService; //autowire the user repo

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String userName = "";
        userName = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();
        User user = userService.findByUsername(userName);
        logger.info("userName: " + userName);
        HttpSession session = request.getSession();
        String referer = (String) session.getAttribute("referer");
        session.setAttribute("user", user);
        SetupSession.setHeader(user.getCartItems().size() ,user.getProLiked().size(), request);
        Set<Permission> permission=user.getPermissions();
        if (referer.equals("/admin")) {
        	for (Permission p : permission) {
            	if (p.getPermissionName().equals("ADMIN")) {
            		referer="/admin";
            	}
            }
        }
        redirectStrategy.sendRedirect(request, response, referer);
    }
}
