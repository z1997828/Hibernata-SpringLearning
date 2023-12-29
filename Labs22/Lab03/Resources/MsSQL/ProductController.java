package com.web.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.store.model.BookBean;
import com.web.store.service.ProductService;

@Controller
public class ProductController {
	ProductService service;

	@Autowired 
	public void setService(ProductService service) {
		this.service = service;
	}

	@RequestMapping("/products")
	public String list(Model model) {
		List<BookBean>  list = service.getAllProducts();
		model.addAttribute("products", list);
		return "products";
	}

}
