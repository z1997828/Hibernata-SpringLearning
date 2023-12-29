package _00.init.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00.init.SystemConstant;

/**
 * Application Lifecycle Listener implementation class InitialListener
 *
 */
//@WebListener
public class InitialListener implements ServletContextListener {

	private static Logger log = LoggerFactory.getLogger(InitialListener.class);
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	sce.getServletContext().setAttribute("systemConstant", new SystemConstant());
    	log.info("InitialListener之contextInitialized()執行中...*********");
    }
	
}
