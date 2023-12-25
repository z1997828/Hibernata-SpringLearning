package ch00;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch05._00.utils.GlobalService;

public class ConfigurationSetupListener implements ServletContextListener {
//	private static Logger log = LoggerFactory.getLogger(ConfigurationSetupListener.class);
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("================ ConfigurationSetupListener =================");
    	ServletContext sc = sce.getServletContext();
    	GlobalService globalService = new GlobalService();
    	String target1 = sc.getRealPath("/WEB-INF/classes/db.properties");
    	String target2 = sc.getRealPath("/WEB-INF/classes/hibernate.cfg.xml");
    	String source1 = null;
    	String source2 = null;
    	if (globalService.getDbType().toUpperCase().equals("M")) {
    		source1 = sc.getRealPath("/WEB-INF/classes/dbMySQL.properties");
    		source2 = sc.getRealPath("/WEB-INF/classes/hibernateMySQL.cfg.xml");
    	} else if (globalService.getDbType().toUpperCase().equals("S")) {
    		source1 = sc.getRealPath("/WEB-INF/classes/dbSQLServer.properties");
    		source2 = sc.getRealPath("/WEB-INF/classes/hibernateSQLServer.cfg.xml");
    	}
    	try {
			fileCopy(source1, target1);
			fileCopy(source2, target2);
			System.out.println("資料庫類型: " + globalService.getDbType() + ", db.properties / hibernate.cfg.xml 設定成功");
		} catch (IOException e) {
			System.out.println("資料庫類型: " + globalService.getDbType() + ", db.properties / hibernate.cfg.xml 設定失敗");
			e.printStackTrace();
		}
    	
    }
    public void fileCopy(String source, String target) 
    		  throws IOException {
   			Path sourcePath = Paths.get(source);
   		    Path targetPath = Paths.get(target);
   		    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
