package com.shelmark.demo.ClientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Service.ProductService;

@Controller
@RequestMapping("/product")
public class ClientProductController {
	@Autowired
	private ProductService proService;
	@RequestMapping(value="")
	public ModelAndView showProsByCatId(@RequestParam Long catId) {
		List<Product> pros = proService.getAllProduct();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("proByCat");
		return mv;
	}
}
