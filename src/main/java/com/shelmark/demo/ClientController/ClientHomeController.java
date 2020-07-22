package com.shelmark.demo.ClientController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Service.ProductService;

@Controller
public class ClientHomeController {
	
	@Autowired
	private ProductService proService;
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Product> pros = proService.getAllMostResearch();
		mv.addObject("pros", pros);
		List<Product> latestPros = proService.getAllProDate();
		List<Product> ratedPros = proService.getAllProRating();
		List<Product> bestSeller = proService.getAllProSold();
		mv.addObject("latestPros", latestPros);
		mv.addObject("ratedPros", ratedPros);
		mv.addObject("bestSeller", bestSeller);
		mv.setViewName("clientHome");
		return mv;
	}
	@RequestMapping(value="/back", method=RequestMethod.GET)
	public String back(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "redirect:"+session.getAttribute("referer");
	}
}
