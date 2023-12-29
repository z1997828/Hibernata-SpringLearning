package com.web.store.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
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
	
	@GetMapping("/products/add")
	public String getAddNewProductForm(Model model) {
	    BookBean bb = new BookBean();
	    model.addAttribute("bookBean", bb); 
	    return "addProduct";
	}

	@PostMapping("/products/add")
	public String processAddNewProductForm(
			@ModelAttribute("bookBean") BookBean bb,
			BindingResult result ) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("嘗試傳入不允許的欄位: " + 
		    StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
 
		if (bb.getStock() == null) {
			bb.setStock(0);
		}
		productService.addProduct(bb);
	    return "redirect:/products";
	}

	@ModelAttribute("companyList")
	public Map<Integer, String> getCompanyList() {
	    Map<Integer, String> companyMap = new HashMap<>();
	    List<CompanyBean> list = productService.getCompanyList();
	    for (CompanyBean cb : list) {
	        companyMap.put(cb.getId(), cb.getName());
	    }
	    return companyMap;
	}

	@ModelAttribute("categoryList")
	public List<String> getCategoryList() {
	    return productService.getAllCategories();
	}
	
	@InitBinder
    public void whiteListing(WebDataBinder binder) {
   	    binder.setAllowedFields(
            "author", 
   	        "bookNo", 
   	        "category", 
            "price", 
            "title", 
            "companyId" 
   	    );
    }

}