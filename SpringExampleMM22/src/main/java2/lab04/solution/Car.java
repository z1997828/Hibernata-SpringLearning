package lab04.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements ICar{
	private Integer speed;
	private Double hour;
	
	@Autowired
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	@Autowired
	public void setHour(Double hour) {
		this.hour = hour;
	}

	public Car() {
	}
	
	public void getComment() {
		System.out.println("此車走了" + speed * hour + "公里");
	}

}
