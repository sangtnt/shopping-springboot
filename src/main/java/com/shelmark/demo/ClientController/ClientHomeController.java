package com.shelmark.demo.ClientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Service.CategoryService;
import com.shelmark.demo.Service.ProductService;

@Controller
public class ClientHomeController {
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private ProductService proService;
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Category> cats = catService.getAllCategory();
		List<Product> pros = proService.getAllMostResearch();
		mv.addObject("cats", cats);
		mv.addObject("pros", pros);List<Product> latestPros = proService.getAllProDate();
		List<Product> ratedPros = proService.getAllProRating();
		List<Product> bestSeller = proService.getAllProSold();
		mv.addObject("latestPros", latestPros);
		mv.addObject("ratedPros", ratedPros);
		mv.addObject("bestSeller", bestSeller);
		mv.setViewName("clientHome");
		return mv;
	}
}
