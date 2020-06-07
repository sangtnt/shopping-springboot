package com.shelmark.demo.ClientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Service.CategoryService;

@Controller
public class ClientHomeController {
	@Autowired
	private CategoryService catService;
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Category> cats = catService.getAllCategory();
		mv.addObject("cats", cats);
		mv.setViewName("clientHome");
		return mv;
	}
}
