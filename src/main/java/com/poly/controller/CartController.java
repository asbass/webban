package com.poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.OrderDetailDAO;
import com.poly.dao.ProductDAO;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.utils.CartItems;



@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ProductDAO pd;
	@Autowired
	OrderDetailDAO dao;
	@Autowired
	HttpSession ss;
	
	
	@GetMapping("/view")
	public String index(Model model) {
		model.addAttribute("cartItems", ss.getAttribute("cart"));
		System.out.println(ss.getAttribute("user"));
		model.addAttribute("user", ss.getAttribute("user"));
		System.out.println(model.getAttribute("user"));
		return "site/cart";
	}
	
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") int id, @RequestParam("url") String url, @RequestParam("quantity") int quantity) {
		Product p = pd.findById(id).get();
		((CartItems)ss.getAttribute("cart")).addItems(p, quantity);
		return "redirect:/"+url;
	}
	
	@GetMapping("/modify/{id}")
	public String modify(@PathVariable("id") int id, @RequestParam("url") String url, @RequestParam("quantity") int quantity) {
		Product p = pd.findById(id).get();
		((CartItems)ss.getAttribute("cart")).modifyQuantity(p, quantity);
		return "redirect:/"+url;
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") String id, @RequestParam("url") String url) {
		((CartItems)ss.getAttribute("cart")).removeItem(id);
		return "redirect:/"+url;
	}
	
}
