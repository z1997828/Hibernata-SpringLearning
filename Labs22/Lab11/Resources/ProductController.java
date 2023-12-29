package com.web.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		List<String> list = productService.getAllCategories();
		model.addAttribute("categoryList", list);
		return "types/category";
	}

	@GetMapping("/products/{category}")
	public String getProductsByCategory(@PathVariable("category") String category, Model model) {
		List<BookBean> products = productService.getProductsByCategory(category);
		model.addAttribute("products", products);
		return "products";
	}

	@GetMapping("/product")
	public String getProductById(@RequestParam("id") Integer id, Model model) {
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
	public String processAddNewProductForm(@ModelAttribute("bookBean") BookBean bb, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("嘗試傳入不允許的欄位: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
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
		binder.setAllowedFields("author", "bookNo", "category", "price", "title", "companyId");
	}

	// return "forward:/anotherFWD": 轉發(forward)給能夠匹配給 /anotherFWD的控制器方法
	// 將與下一棒的程式共用同一個請求物件
	// return "anotherFWD": 也是轉發，但Spring框架會視anotherFWD為視圖的邏輯名稱來尋找
	// 對應的視圖，然後由該視圖來產生回應
	@GetMapping("/forwardDemo")
	public String forward(Model model, HttpServletRequest request) {
		String uri = request.getRequestURI();
		model.addAttribute("modelData0", "這是以/forwardDemo送來的請求");
		model.addAttribute("uri0", uri);
		return "forward:/anotherFWD";
	}

	// 被轉發的方法，將與前一個方法共用同一個請求物件
	@GetMapping("/anotherFWD")
	public String forwardA(Model model, HttpServletRequest request) {
		String uri = request.getRequestURI();
		model.addAttribute("modelData1", "這是以/anotherFWD送來的請求");
		model.addAttribute("uri1", uri);
		return "forwardedPage";
	}

	// return "redirect:/redirectAnother": 通知瀏覽器對新網址 /redirectAnother發出請求，即重定向
	// (redirect)。由於是另外一個請求，所以放在原來之請求物件內的資料將不存在。必須將屬性物件儲存
	// 在 RedirectAttributes物件內，另外一個請求才會看的到對應的視圖，然後由該視圖來產生回應。
	@GetMapping("/redirectDemo")
	public String redirect(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String uri = request.getRequestURI();
		model.addAttribute("modelData2", "這是以/redirectDemo送來的請求，即將通知瀏覽器對" + "新網址發出請求，但瀏覽器不會顯示這樣的訊息");
		model.addAttribute("uri2", uri);
		redirectAttributes.addFlashAttribute("modelData3", "這是加在RedirectAttributes" + "物件內的屬性物件，瀏覽器會顯示");
		redirectAttributes.addFlashAttribute("uri3", uri);
		return "redirect:/redirectAnother";
	}

	// -------------------------
	// 瀏覽器對新網址重新發出的請求將會由這個請求器方法來處理
	@GetMapping("/redirectAnother")
	public String redirectA(Model model, HttpServletRequest request) {
		return "redirectedPage";
	}
}