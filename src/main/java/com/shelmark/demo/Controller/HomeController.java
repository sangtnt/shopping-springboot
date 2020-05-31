package com.shelmark.demo.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.HomeService;
import com.shelmark.demo.Service.ImageService;

@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getUsers(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer limit) {
		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		ModelAndView mv = new ModelAndView();
		int start = (page - 1) * limit;
		List<User> users = homeService.getUserByPage(start, limit);
		mv.setViewName("userList");
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer limit) {
		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		ModelAndView mv = new ModelAndView();
		int start = (page - 1) * limit;
		List<Category> cats = homeService.getCatsByPage(start, limit);
		mv.setViewName("categoryList");
		mv.addObject("cats", cats);
		return mv;
	}

	@RequestMapping(value = "/editCat", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam(required = false) Long catId) {
		Category cat = homeService.getCatById(catId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editCat");
		mv.addObject("cat", cat);
		return mv;
	}
	
	@RequestMapping(value = "/addCat", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCat");
		return mv;
	}
	
	@RequestMapping(value = "/addCat", method = RequestMethod.POST)
	public String addCat(@RequestParam String catName, @RequestParam(required=false) MultipartFile file) {
		Category cat = new Category();
		String img;
		if (!file.isEmpty()) {
			img = imgService.uploadFile(uploadRootPath+"/category", file);
		}
		else {
			img="";
		}
		cat.setName(catName);
		cat.setImage("/img/category/"+img);
		homeService.addCat(cat);
		return "redirect:/category";
	}
	
	@RequestMapping(value = "/deleteCat", method = RequestMethod.POST)
	public String deleteCategory(@RequestParam(required = false) Long catId) {
		Category cat = homeService.getCatById(catId);
		homeService.delete(cat);
		return "redirect:/category";
	}
	
	@Autowired
	private ImageService imgService;
	
	public static String uploadRootPath = System.getProperty("user.dir")+"/src/main/resources/static/img";
	@RequestMapping(value = "/editCat", method = RequestMethod.POST)
	public String editCat(@RequestParam Long catId, @RequestParam String catName, @RequestParam(required=false) MultipartFile file) {
		Category cat = homeService.getCatById(catId);
		cat.setName(catName);
		if (!file.isEmpty()) {
			String img = imgService.uploadFile(uploadRootPath+"/category", file);
			cat.setImage("/img/category/"+img);
		}
		homeService.update(cat);
		return "redirect:/category";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer limit) {
		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		ModelAndView mv = new ModelAndView();
		int start = (page - 1) * limit;
		List<Product> pros = homeService.getProductsByPage(start, limit);
		DateFormat df = new SimpleDateFormat("dd:MM:yyyy");
		for (Product pro : pros) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(Long.parseLong(pro.getDate()));
			pro.setDate(df.format(cal.getTime()));
		}
		mv.setViewName("productList");
		mv.addObject("pros", pros);
		return mv;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
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
		List<Order> orders = homeService.getOrdersByPage(start, limit);
		mv.setViewName("cusOrder");
		mv.addObject("orders", orders);
		return mv;
	}

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public ModelAndView showOrderDetail(@RequestParam(required = false) Long orderId) {
		ModelAndView mv = new ModelAndView();
		Order order = homeService.getOrderById(orderId);
		mv.setViewName("orderDetail");
		mv.addObject("order", order);
		return mv;
	}
}
