package com.shelmark.demo.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.CategoryService;
import com.shelmark.demo.Service.OrderService;
import com.shelmark.demo.Service.PermissionService;
import com.shelmark.demo.Service.ProductService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/admin/search")
public class SearchController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService perService;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private ProductService proService;
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam String catForSearch, @RequestParam String searchText) {
		ModelAndView mv= new ModelAndView();
		if(catForSearch.equals("user")) {
			Set<User> users = new HashSet<User>();
			User u = userService.findByUsername(searchText);
			if (u!=null) {
				users.add(u);
			}
			List<User> fullnames=userService.findByFullname(searchText);
			if(fullnames!=null) {
				users.addAll(fullnames);
			}
			List<User> phones=userService.findByPhone(searchText);
			if(phones!=null) {
				users.addAll(phones);
			}
			List<User> emails=userService.findByEmail(searchText);
			if(emails!=null) {
				users.addAll(emails);
			}
			mv.addObject("users", users);
			mv.setViewName("userList");
		}
		else if(catForSearch.equals("permission")){
			List<Permission> pers = perService.findByName(searchText);
			mv.addObject("pers", pers);
			mv.setViewName("permissionList");
		}
		else if(catForSearch.equals("category")) {
			List<Category> cats = catService.findByName(searchText);
			mv.addObject("cats", cats);
			mv.setViewName("categoryList");
		}
		else if(catForSearch.equals("product")) {
			Set<Product> pros = new HashSet<Product>();
			List<Product> names = proService.findByName(searchText);
			List<Product> catNames = proService.findByCatName(searchText);
			if (names!=null) {
				pros.addAll(names);
			}
			if (catNames!=null) {
				pros.addAll(catNames);
			}
			mv.addObject("pros",pros);
			mv.setViewName("productList");
		}
		else if(catForSearch.equals("order")){
			try {
				Long id = Long.parseLong(searchText);
				Order order = orderService.getOrderById(id);
				mv.addObject("order", order);
			}
			catch(Exception e) {
				mv.addObject("order", null);
			}
			mv.setViewName("orderDetail");
		}
		else {
			mv.setViewName("admin404");
		}
		return mv;
	}
}
