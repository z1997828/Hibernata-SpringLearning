package ch04.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ch03.model.Cat;

@Controller
@SessionAttributes("ShoppingCart")
@RequestMapping("/ch04")
public class Ch04Controller9 {

	private static Logger log = LoggerFactory.getLogger(Ch04Controller9.class);
	
	ServletContext context;
	
	@Autowired
	public Ch04Controller9(ServletContext context) {
		this.context = context;
	}

	@GetMapping("/SessionStatus_setComplete")
	public String SessionStatus_setComplete(SessionStatus status) {
		log.info("執行status.setComplete();");
		status.setComplete();
		return "ch03/thirdPage";
	}
	
	// 了解Spring MVC中，Session#invalidate()方法對@SessionAttributes的影響 
	@GetMapping("/SessionInvalidate")
	public String delete(HttpSession session) {
		Cat c0 = (Cat)session.getAttribute("cat");
		log.info("執行session.invalidate()之前的Cat物件=" + c0);
		log.info("執行session.invalidate();");
		session.invalidate();
		try {
			Cat c1 = (Cat)session.getAttribute("cat");
			log.info("執行session.invalidate()之後的Cat物件=" + c1);
		} catch(Exception e) {
			log.info("已經執行session.invalidate()後就無法再存取Session內的屬性物件");
		}
		return "ch03/thirdPage";
	}
	
	@GetMapping("/inspectSession")
	public String inspect(HttpSession session, Model model) {
		Cat c1 = (Cat) model.getAttribute("cat");
		log.info("in inspectSession, through model, cat=" + c1);
		Cat c2 = (Cat) session.getAttribute("cat");
		log.info("in inspectSession, through session, cat=" + c2);
		return "ch03/thirdPage";
	}

}
 