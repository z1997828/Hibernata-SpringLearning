package ch03.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch03.model.Cat;

@Controller
@SessionAttributes({"cat", "dog"})
@RequestMapping("/ch03")
public class Ch03Controller1 {
	
	private static Logger log = LoggerFactory.getLogger(Ch03Controller1.class);
	
	@GetMapping("/index")
	public String mappings(Model model) {
		Cat c = (Cat)model.getAttribute("cat");
		model.addAttribute("indexPageCat", c);
		return "ch03/index";
	}
	
	@ModelAttribute("cat")
	public Cat modelAttribute(HttpServletRequest req, Model model) {
		Cat c = new Cat();
		log.info("在Ch03Controller1類別內的@ModelAttribute修飾的方法中,新建Cat物件=" + c);
		return c;
	}
}
 