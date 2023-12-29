package ch03.model;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Cat {
	String timeCreating; 
	
	public Cat() {
		Date date = new Date();
		timeCreating = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(date);
	}
	
	public String getTimeCreating() {
		return timeCreating;
	}

	public void setTimeCreating(String timeCreating) {
		this.timeCreating = timeCreating;
	}

	@Override
	public String toString() {
		return "Cat [createTime=" + timeCreating + "], hashCode=" + hashCode();
	} 
	
}
