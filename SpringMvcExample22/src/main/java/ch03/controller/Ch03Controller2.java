package ch03.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch03.model.Cat;

@Controller
@SessionAttributes("cat")
@RequestMapping("/ch03")
public class Ch03Controller2 {

	private static Logger log = LoggerFactory.getLogger(Ch03Controller2.class);
	
	@GetMapping("/secondPage")
	public String nextPage(Model model, HttpServletRequest request) {
		log.info("Ch03Controller2執行中");
		Cat c = (Cat)model.getAttribute("cat");
		model.addAttribute("secondPageCat", c);
		return "ch03/secondPage";
	}

}
 