package lab05.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	public double radius;

	@Autowired
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle() {
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}
	
}