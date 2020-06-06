package com.shelmark.demo.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired 
	private ProductService proService;
	@RequestMapping(value = "", method = RequestMethod.GET)
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
		List<Product> pros = proService.getProductsByPage(start, limit);
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
}
