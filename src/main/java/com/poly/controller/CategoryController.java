package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import com.poly.service.SessionService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	CategoryDAO dao;
	@Autowired
	SessionService session;

	@RequestMapping("index")
	public String index(Model model,	@RequestParam("c") Optional<Integer> c) {
		Category item = new Category();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(c.orElse(0), 5);
		Page<Category> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/category/index";
	}

	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") String id,	@RequestParam("c") Optional<Integer> c) {
		Category item = dao.findById(id).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(c.orElse(0), 5);
		Page<Category> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/category/index";
	}
	@RequestMapping("/add")
	public String create(Category item) {
		dao.save(item);
		return "redirect:index";
	}

	@RequestMapping("/update")
	public String update(Category item) {
		dao.save(item);
		return "redirect:edit/" + item.getId();
	}

	@RequestMapping("delete/{id}")
	public String create(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/admin/categories/index";
	}

	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") Optional<String> kw,
			@RequestParam("c") Optional<Integer> c) {
		String keywords = kw.orElse(session.get("keywords", ""));
		session.set("keywords", keywords);
		Pageable pageable = PageRequest.of(c.orElse(0), 5);
		//Page<Product> page = dao.findByKeywords("%"+keywords+"%", pageable);
		Page<Category> page = dao.findAllByNameLike("%"+keywords+"%", pageable);
		model.addAttribute("page", page);
		return "admin/category/index";
	}
	@RequestMapping("reset")
	public String reset() {
		return "redirect:/admin/categories/index";
	}
}
