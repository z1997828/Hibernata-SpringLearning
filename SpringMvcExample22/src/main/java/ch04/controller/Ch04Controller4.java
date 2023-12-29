package ch04.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("ShoppingCart")
@RequestMapping("/ch04")
public class Ch04Controller4 {
	
	private static Logger log = LoggerFactory.getLogger(Ch04Controller4.class);
	
	@GetMapping("/fourthPage")
	public String fourthPage(Model model, HttpServletRequest request) {
		log.info("/fourthPage執行中...");
		return "ch04/fourthPage";	
	}

}
 