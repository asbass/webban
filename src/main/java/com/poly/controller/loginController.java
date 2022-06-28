package com.poly.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;

@Controller

public class loginController {
	@Autowired
	AccountDAO dao;
	@Autowired
	HttpSession session;
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model, 
			Account a, RedirectAttributes ra) {
		Optional<Account> account = dao.checkLogin(a.getUsername(), a.getPassword());
		if(account.orElse(new Account()).getUsername() != null) {
			session.setAttribute("user", account.get());
			
			System.out.println(	session.getAttribute("user"));

			if(account.get().isAdmin()) {
				return "redirect:/admin/account/list";
			} else {
				return "redirect:/index";
			}
		} else {
			ra.addAttribute("message", "User name or password is wrong");
			return "redirect:/login";
		}

	}
	
	@RequestMapping("logoff")
	public String logoff() {
		session.removeAttribute("user");
		return "redirect:/index";

	}
	@RequestMapping("register")
	public String register() {
		return "user/index";
	}
	@RequestMapping("activate")
	public String activate() {
		return "user/index";
	}
	@RequestMapping("forgot-password")
	public String forgot() {
		return "user/index";
	}
	
	@RequestMapping("chgpwd")
	public String change(Model model) {
		model.addAttribute("message", "Change Password");
		return "user/index";
	}
	
	/*
	@RequestMapping("edit")
	public String edit(Model model) {
		model.addAttribute("message", "Edit");
		return "user/index";
	}
	*/		
}
