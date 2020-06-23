package com.shelmark.demo.ClientController;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.OrderByDate;
import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.OrderService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/order")
public class ClientOrderController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="", method= RequestMethod.GET)
	public ModelAndView showAllOrders(HttpServletRequest request) {
		HttpSession session= request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		ModelAndView mv = new ModelAndView();
		List<Order> orders = user.getOrders();
		OrderByDate o = new OrderByDate();
		Collections.sort(orders, o);
		mv.addObject("orders", user.getOrders());
		mv.setViewName("clientOrder");
		return mv;
	}
	
	@RequestMapping(value="/cancelOrder", method= RequestMethod.GET)
	public String cancel(@RequestParam Long orderId) {
		Order order = orderService.getOrderById(orderId);
		order.setStatus(5);
		orderService.save(order);
		return "redirect:/order";
	}
}
