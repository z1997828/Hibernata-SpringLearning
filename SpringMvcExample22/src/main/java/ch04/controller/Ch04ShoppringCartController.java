package ch04.controller;

import java.util.Map;
import java.util.Set;

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
public class Ch04ShoppringCartController {
	
	private static Logger log = LoggerFactory.getLogger(Ch04ShoppringCartController.class);
	
	@GetMapping("showCartContent")
	public String showCartContent(Model model) {
		Map<String, Object> map = model.asMap();
		Set<String> set = map.keySet();
		for (String key : set) {
			log.info(key + ":" + map.get(key));
		}
		return "ch04/showCartContent";
	}
}
