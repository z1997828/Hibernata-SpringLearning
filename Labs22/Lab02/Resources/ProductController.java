package com.web.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
 
@Controller
public class ProductController {
	
	@GetMapping("/products")
	public String list(Model model) {
		CompanyBean cb = new CompanyBean(1, "學貫行銷股份有限公司", "台北市林森南路四號六樓", 
										"http://www.xbook.com.tw/");
		BookBean bb = new BookBean(1002, "PHP&MySQL程式設計實例講座", "陳惠貞", 580.0, 0.6, 
									"bookxb002.jpg", "P832", null, 25,	"Web", cb);
		model.addAttribute("product", bb);
		return "products";
	}
}
