package com.shelmark.demo.ClientController;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.ProductService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/product")
public class ClientProductController {
	@Autowired
	private ProductService proService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "")
	public ModelAndView showProsByCatId(@RequestParam Long catId) {
		List<Product> latestPros = proService.getProByOrderAndDate(catId);
		List<Product> ratedPros = proService.getProByCatAndRating(catId);
		List<Product> bestSeller = proService.getProByCatAndSold(catId);
		List<Product> allPros = proService.findByCat(catId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("latestPros", latestPros);
		mv.addObject("ratedPros", ratedPros);
		mv.addObject("bestSeller", bestSeller);
		mv.addObject("allPros", allPros);
		mv.setViewName("proByCat");
		return mv;
	}

	@RequestMapping(value = "/proDetail")
	public ModelAndView proDetail(@RequestParam() Long proId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Product pro = proService.findById(proId);
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = null;
		if (u != null) {
			user = userService.findByUsername(u.getUsername());
		}
		if (request.getHeader("referer") != null) {
			String referer = request.getHeader("referer");
			if (referer.contains("search")) {
				Long s = (long) 0;
				if (pro.getResearch() == null) {
					s += 1;
				} else {
					s = pro.getResearch() + 1;
				}
				pro.setResearch(s);
				proService.save(pro);
			}
		}
		List<Product> relatedPros = proService.getProByCatAndRating(pro.getCat().getId());
		mv.addObject("pro", pro);
		mv.addObject("user", user);
		mv.addObject("relatedPros", relatedPros);
		mv.setViewName("clientProDetail");
		return mv;
	}

	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam String name) {
		List<Product> products = proService.findAll();
		List<Product> pros = products.stream().filter(pro -> {
			return pro.getName().toLowerCase().contains(name.toLowerCase());
		}).collect(Collectors.toList());
		List<Product> prosByCat = products.stream().filter(pro -> {
			return pro.getCat().getName().toLowerCase().contains(name.toLowerCase());
		}).collect(Collectors.toList());
		pros.addAll(prosByCat);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pros", pros);
		mv.addObject("name", name);
		mv.setViewName("clientSearch");
		return mv;
	}
}
