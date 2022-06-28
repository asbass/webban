package com.poly.controller;

import java.io.File;
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

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.SessionService;

@Controller
@RequestMapping("admin/account")
public class accountController {
	@Autowired
	AccountDAO dao;

	@Autowired
	SessionService session;
	@Autowired
	ServletContext app;
	@RequestMapping("index")
	public String index(Account item,Model model) {
		model.addAttribute("item", new Account());
	return "admin/account/add";
	}

	@RequestMapping("edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		Account item = dao.findById(username).get();
		model.addAttribute("item", item);
		return "admin/account/add";
	}

	
	@RequestMapping("/add")
	public String create(Account item,Model model,@RequestParam("images") MultipartFile image) {
		if(image.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				//String path = app.getRealPath("/images/"+filename);
				File file = new File(app.getRealPath("/images/"+filename));
				image.transferTo(file);
				item.setPhoto(filename);
				dao.save(item);
				return "redirect:index";
			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "redirect:/admin/account/search";
	}

	@RequestMapping("update")
	public String update(Account item,Model model,@RequestParam("images") MultipartFile image) {
		if(image.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				//String path = app.getRealPath("/images/"+filename);
				File file = new File(app.getRealPath("/images/"+filename));
				image.transferTo(file);
				item.setPhoto(filename);
				dao.save(item);
				model.addAttribute("message", "cập nhật thành công !");
				return "redirect:edit/" + item.getUsername();
				
			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "redirect:edit/" + item.getUsername();

	}

	@RequestMapping("delete/{username}")
	public String create(@PathVariable("id") String username) {
		dao.deleteById(username);
		return "redirect:/admin/account/search";
	}

	@RequestMapping("search")
	public String search(Model model,@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String keywords = kw.orElse(session.get("keywords", ""));
		session.set("keywords", keywords);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		//Page<Product> page = dao.findByKeywords("%"+keywords+"%", pageable);
		Page<Account> page = dao.findAllByFullnameLike("%"+keywords+"%", pageable);
		model.addAttribute("page", page);
		return "admin/account/list";
	}
	@RequestMapping("reset")
	public String reset() {
		return "redirect:/admin/account/index";
	}
}
