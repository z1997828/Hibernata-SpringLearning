package com.web.store.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.store.model.BookBean;
import com.web.store.service.ProductService;

@Controller
public class ProductController {
	
	ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public String list(Model model) {
		List<BookBean> list = productService.getAllProducts();
		model.addAttribute("products", list);
		return "products";
	}
}
