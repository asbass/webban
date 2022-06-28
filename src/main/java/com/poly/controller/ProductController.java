package com.poly.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dao.CategoryDAO;
import com.poly.dao.ProductDAO;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.SessionService;

@Controller
@RequestMapping("admin/product")
public class ProductController {
	@Autowired
	ProductDAO dao;
	@Autowired
	CategoryDAO daos;
	@Autowired
	SessionService session;
	@Autowired
	ServletContext app;
	@RequestMapping("index")
	public String index(Product item,Model model) {
		model.addAttribute("item", new Product());
		List<Category> items = daos.findAll();
		model.addAttribute("items", items);
	return "admin/product/add";
	}

	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		Product item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = daos.findAll();
		model.addAttribute("items", items);
		return "admin/product/add";
	}

	
	@RequestMapping("/add")
	public String create(Product item,Model model,@RequestParam("images") MultipartFile image) {
		if(image.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				//String path = app.getRealPath("/images/"+filename);
				File file = new File(app.getRealPath("/images/"+filename));
				image.transferTo(file);
				item.setImage(filename);
				dao.save(item);
				return "redirect:index";
			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "redirect:/admin/product/search";
	}

	@RequestMapping("update")
	public String update(Product item,Model model,@RequestParam("images") MultipartFile image) {
		if(image.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				//String path = app.getRealPath("/images/"+filename);
				File file = new File(app.getRealPath("/images/"+filename));
				image.transferTo(file);
				item.setImage(filename);
				dao.save(item);
				model.addAttribute("message", "cập nhật thành công !");
				return "redirect:edit/" + item.getId();
				
			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "redirect:edit/" + item.getId();

	}

	@RequestMapping("delete/{id}")
	public String create(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/admin/product/search";
	}

	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String keywords = kw.orElse(session.get("keywords", ""));
		session.set("keywords", keywords);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		//Page<Product> page = dao.findByKeywords("%"+keywords+"%", pageable);
		Page<Product> page = dao.findAllByNameLike("%"+keywords+"%", pageable);
		model.addAttribute("page", page);
		return "admin/product/list";
	}
	@RequestMapping("reset")
	public String reset() {
		return "redirect:/admin/product/index";
	}
	
}
