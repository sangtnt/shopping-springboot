package com.shelmark.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Service.PermissionService;

@Controller
@RequestMapping("/admin/permission")
public class PermissionController {
	@Autowired
	private PermissionService perService;
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public ModelAndView viewPermission() {
		ModelAndView mv = new ModelAndView();
		List<Permission> pers = perService.findAll();
		mv.setViewName("permissionList");
		mv.addObject("pers", pers);
		return mv;
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public ModelAndView addPermission() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addPermission");
		return mv;
	}
	
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public String add(@RequestParam String perName) {
		Permission per = new Permission();
		per.setPermissionName(perName);
		perService.save(per);
		return "redirect:/admin/permission";
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public String delete(@RequestParam Long id) {
		Permission per = perService.findById(id);
		perService.delete(per);
		return "redirect:/admin/permission";
	}
}
