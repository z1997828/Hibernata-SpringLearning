package _00.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import _00.init.SystemConstant;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static Logger log = LoggerFactory.getLogger(WebAppInitializer.class);
	// getRootConfigClasses()會傳回提供組態資訊(Java based configuration)的Java類別，
	// 本例為RootAppConfig類別，它說明應用系統中，提供Service/Dao功能之Bean的組態資訊，例如提供
	// DataSource類別、交易管理器(Transaction managers)、Hibernate的SessionFactory類別等。
	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("準備建立RootApplicationContext物件");
		return new Class[] {RootAppConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("準備建立ApplicationContext物件");
		return new Class[] {WebAppConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		log.info("定義DispatcherServlet物件要處理之urlPattern");
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter};
	}
	@Override
	public void onStartup(ServletContext context) throws ServletException {
	    super.onStartup(context);
//	    context.addListener(_00.init.listener.InitialListener.class);
//	    //-------------------------
//	    String inFileLocation = "";
//		if (SystemConstant.DB_TYPE == SystemConstant.MYSQL) {
//			inFileLocation = "/WEB-INF/db_MySQL.properties";
//		} else if (SystemConstant.DB_TYPE == SystemConstant.SQL_SERVER) {
//			inFileLocation = "/WEB-INF/db_SQLServer.properties";
//		}
//	    String realPath = context.getRealPath("/WEB-INF/classes");
//	    File folder = new File(realPath);
//	    File outFile = new File(folder, "db.properties");
//	    
//	    try (
//				FileOutputStream fos = new FileOutputStream(outFile);
//				InputStream is = context.getResourceAsStream(inFileLocation);
//				BufferedReader br = new BufferedReader(
//										new InputStreamReader(is));
//				PrintWriter out = new PrintWriter(
//						                new OutputStreamWriter(fos));	
//			) {
//				String line = "";
//				while ((line = br.readLine()) != null) {
//					out.println(line);
//					System.out.println(line);
//				}
//				System.out.println("檔案db.properties建立完畢");
//			} 
//	    catch(Exception e) {
//	    	e.printStackTrace();
//	    }
	}
}
