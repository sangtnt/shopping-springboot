package com.shelmark.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getOrder(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer limit) {
		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		// get data by page
		ModelAndView mv = new ModelAndView();
		int start = (page - 1) * limit;
		List<Order> orders = orderService.getOrdersByPage(start, limit);
		mv.setViewName("cusOrder");
		mv.addObject("orders", orders);
		return mv;
	}

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public ModelAndView showOrderDetail(@RequestParam(required = false) Long orderId) {
		ModelAndView mv = new ModelAndView();
		Order order = orderService.getOrderById(orderId);
		mv.setViewName("orderDetail");
		mv.addObject("order", order);
		return mv;
	}
	
	@RequestMapping(value = "/changeOrder", method = RequestMethod.POST)
	public String change(@RequestParam Long orderId, @RequestParam Integer orderStatus, HttpServletRequest request) {
		Order order = orderService.getOrderById(orderId);
		order.setStatus(orderStatus);
		orderService.save(order);
		String referer="/admin/order";
		if (request.getHeader("referer")!=null) {
			referer=request.getHeader("referer");
		}
		return "redirect:"+referer;
	}
}
