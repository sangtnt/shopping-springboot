package com.shelmark.demo.Service;

import java.io.IOException;
import java.security.Principal;

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

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.UserRepository;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired HttpSession session; //autowiring session

    @Autowired UserRepository repository; //autowire the user repo

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String userName = "";
        if(authentication.getPrincipal() instanceof Principal) {
             userName = ((Principal)authentication.getPrincipal()).getName();

        }else {
            userName = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();
        }
        User user = repository.findByUsername(userName);
        logger.info("userName: " + userName);
        //HttpSession session = request.getSession();
        session.setAttribute("user", user);
   	 	redirectStrategy.sendRedirect(request, response, "/");
    }

}
