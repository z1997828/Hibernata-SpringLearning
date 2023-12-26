package lab06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


public class Car implements ICar{
	
	
	private Integer speed;
	
	private Double hour;
    
	public Car() {
	}
	
	public void getComment() {
		System.out.println("此車走了" + speed * hour + "公里");
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Double getHour() {
		return hour;
	}

	public void setHour(Double hour) {
		this.hour = hour;
	}
	
}
