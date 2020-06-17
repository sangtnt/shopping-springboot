package com.shelmark.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetupSession {
	public static void setHeader(int cartItems, int likes, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("cartItems", cartItems);
		session.setAttribute("likes", likes);
	}
}
