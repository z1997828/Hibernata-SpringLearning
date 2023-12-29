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
public class Ch03Controller3 {
	private static Logger log = LoggerFactory.getLogger(Ch03Controller3.class);
	
	@GetMapping("/thirdPage")
	public String thirdPage(Model model, HttpServletRequest request) {
		log.info("Ch03Controller3執行中");
		Cat c = (Cat)model.getAttribute("cat");
		model.addAttribute("thirdPageCat", c);
		return "ch03/thirdPage";
	}

}
 