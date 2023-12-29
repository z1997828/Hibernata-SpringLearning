package mvc.examples.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class Cat {
	
	private static Logger log = LoggerFactory.getLogger(Cat.class);
	
	String timeCreating; 
	
	public Cat() {
		log.info("Cat類已實例化...");
		Date date = new Date();
		timeCreating = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public String getTimeCreating() {
		return timeCreating;
	}

	public void setTimeCreating(String timeCreating) {
		this.timeCreating = timeCreating;
	}

	@Override
	public String toString() {
		return "Cat [createTime=" + timeCreating + "]";
	} 
	
}
