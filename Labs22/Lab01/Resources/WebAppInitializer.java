package com.web.store.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override       
	protected Class<?>[] getServletConfigClasses() {   // 取代Spring的組態檔
	    return new Class[]{WebAppConfig.class};
	}

	@Override  
	// 定義DispatcherServlet的ServletMapping，"/"表示分派器要處理所有請求。
	protected String[] getServletMappings() {    
	    return new String[]{"/"};
	}
}
