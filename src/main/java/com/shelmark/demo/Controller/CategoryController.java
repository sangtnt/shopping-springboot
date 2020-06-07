package com.shelmark.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Service.CategoryService;
import com.shelmark.demo.Service.ImageService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired 
	private CategoryService catService;
	
	public static String uploadRootPath = System.getProperty("user.dir") + "/src/main/webapp/resources/static/img";
	
	@RequestMapping(value = "", method = RequestMethod.GET)
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
		List<Category> cats = catService.getCatsByPage(start, limit);
		mv.setViewName("categoryList");
		mv.addObject("cats", cats);
		return mv;
	}

	@RequestMapping(value = "/editCat", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam(required = false) Long catId) {
		Category cat = catService.getCatById(catId);
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
	public String addCat(@RequestParam String catName, @RequestParam(required = false) MultipartFile file) {
		Category cat = new Category();
		String img;
		if (!file.isEmpty()) {
			img = imgService.uploadFile(uploadRootPath + "/category", file);
		} else {
			img = "";
		}
		cat.setName(catName);
		cat.setImage("/resources/static/img/category/" + img);
		catService.addCat(cat);
		return "redirect:/admin/category";
	}

	@RequestMapping(value = "/deleteCat", method = RequestMethod.POST)
	public String deleteCategory(@RequestParam(required = false) Long catId) {
		Category cat = catService.getCatById(catId);
		catService.delete(cat);
		return "redirect:/admin/category";
	}

	@Autowired
	private ImageService imgService;

	@RequestMapping(value = "/editCat", method = RequestMethod.POST)
	public String editCat(@RequestParam Long catId, @RequestParam String catName,
			@RequestParam(required = false) MultipartFile file) {
		Category cat = catService.getCatById(catId);
		cat.setName(catName);
		if (!file.isEmpty()) {
			String img = imgService.uploadFile(uploadRootPath + "/category", file);
			cat.setImage("/resources/static/img/category/" + img);
		}
		catService.update(cat);
		return "redirect:/admin/category";
	}

}
