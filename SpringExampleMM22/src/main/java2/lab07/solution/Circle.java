package lab07.solution;

public class Circle implements Shape{
	public double radius;

	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}