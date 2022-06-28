package com.poly.controller;

import java.util.List;
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

import com.poly.dao.OrderDAO;
import com.poly.dao.OrderDetailDAO;
import com.poly.entity.Category;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.entity.Report;
import com.poly.service.SessionService;

@Controller
@RequestMapping("admin/report")
public class reportController {
	@Autowired
	OrderDAO dao;
	@Autowired
	OrderDetailDAO daos;
	@Autowired
	SessionService session;
	@RequestMapping("index")
	public String search(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		List<Report> page = daos.getInventoryByoder();
		model.addAttribute("page", page);
		return "admin/report/list";
	}
//	@RequestMapping("edit/{id}")
//	public String edit(Model model ) {
//		OrderDetail item = daos.findByOrder();
//		model.addAttribute("item", item);	
//		return "admin/report/list";
//	}
}
