package com.web.store.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStocks();
	    return "redirect:/products";
	}   
	
	@GetMapping("/queryByCategory")
	public String getCategoryList(Model model) {
	    List<String>  list = productService.getAllCategories();
	    model.addAttribute("categoryList", list);
	    return "types/category";
	}

	@GetMapping("/products/{category}")
	public String getProductsByCategory(
			@PathVariable("category") String category, 
			Model model
	){
	    List<BookBean> products = productService.getProductsByCategory(category);
	    model.addAttribute("products", products);
	    return "products";
	}
	
	@GetMapping("/product")
	public String getProductById(
			@RequestParam("id") Integer id, 
			Model model
	){
		model.addAttribute("product", productService.getProductById(id));
		return "product";
	}
}
