package ch02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ch02")
public class Ch02_VariousMethods {

	@GetMapping("/welcome0")
	public String welcome0(Model model) {
		model.addAttribute("methodSignature", "public String welcome0(Model model)");
		model.addAttribute("title", "傳回值的型態為String，代表視圖的邏輯名稱");
		model.addAttribute("subtitle", "經由Model的addAttribute()方法加入屬性物件");
		return "ch02/_01/welcome";
	}
	@GetMapping("/welcome1")
	public ModelAndView  welcomeMnV1() {
		ModelAndView modelAndView = new ModelAndView("ch02/_01/welcome");
		modelAndView.addObject("methodSignature", "public ModelAndView  welcomeMnV1()");
		modelAndView.addObject("title", "傳回值的型態為ModelAndView的物件，"
				+ "內含Model And View，<br>視圖的邏輯名稱透過ModelAndView的建構子傳入");
		modelAndView.addObject("subtitle", "經由ModelAndView的addObject()方法加入屬性物件");
		return modelAndView;
	}
	@GetMapping("/welcome2")
	public ModelAndView  welcomeMnV2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("methodSignature", "public ModelAndView  welcomeMnV2()");
		modelAndView.setViewName("ch02/_01/welcome");
		modelAndView.addObject("title", "傳回值的型態為ModelAndView的物件，"
				+ "內含Model And View，<br>視圖的邏輯名稱透過ModelAndView的setViewName()傳入");
		modelAndView.addObject("subtitle", "經由ModelAndView的addObject()方法加入屬性物件");
		return modelAndView;
	}
	@GetMapping("/welcome3")
	public String  welcome3(ModelMap mmap) {
		mmap.addAttribute("methodSignature", "public String  welcome3(ModelMap mmap)");
		mmap.addAttribute("title", "傳回值的型態為String，代表視圖的邏輯名稱");
		mmap.addAttribute("subtitle", "經由ModelMap的addAttribute()方法加入屬性物件");
		return "ch02/_01/welcome";
	}
	@GetMapping("/welcome4")
	public String  welcome4(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("methodSignature", "public String  welcome4(Model model)");
    	map.put("title", "傳回值的型態為String，代表視圖的邏輯名稱");
		model.addAttribute("subtitle", "可經由Map的put()方法與Model的addAttribute()方法加入屬性物件，"
						 + "<br>再由Model的mergeAttributes()方法併入Map內的所有屬性物件到Model物件內");
    	model.mergeAttributes(map);		
		return "ch02/_01/welcome";
	}
}
