package ch05._00.init;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch05._00.utils.GlobalService;
import ch05.ex00.entity.Member;

@WebListener
public class CreateInMemoryMembersListener implements ServletContextListener {

	private static Logger log = LoggerFactory.getLogger(CreateInMemoryMembersListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("================ ServletContextListener =================");
		sce.getServletContext().setAttribute("globalService", new GlobalService());
		
		Member m1 = new Member(0, "kitty101", "Do!ng123", "貓凱蒂", 
				"0919-558802", 2,
				Date.valueOf("1990-5-1"), Timestamp.valueOf("2020-12-25 17:48:12") );
		
		Member m2 = new Member(1, "mickey230", "m!ck3YAbC", "米小薯",	"0937-124990", 3,
				Date.valueOf("1999-12-18"), Timestamp.valueOf("2020-10-17 10:18:10") );
		
		Member m3 = new Member(2, "garfield997", "poInt8523", "賈非貓", "0952-142706", 0, 
				Date.valueOf("2021-3-10"), Timestamp.valueOf("2019-2-9 5:9:30"));
        
		GlobalService.getMembers().add(m1);
		GlobalService.getMembers().add(m2);
		GlobalService.getMembers().add(m3);
		log.info("====================================" + GlobalService.getMembers().toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
