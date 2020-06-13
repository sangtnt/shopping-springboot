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
	@RequestMapping(value="/proDetail")
	public ModelAndView proDetail(@RequestParam() Long proId) {
		ModelAndView mv = new ModelAndView();
		Product pro = proService.findById(proId);
		List<Product> relatedPros = proService.getProByCatAndRating(pro.getCat().getId());
		mv.addObject("pro", pro);
		mv.addObject("relatedPros", relatedPros);
		mv.setViewName("clientProDetail");
		return mv;
	}
}
