package com.shelmark.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class HomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
