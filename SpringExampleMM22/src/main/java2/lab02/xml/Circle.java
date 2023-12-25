package lab02.xml;

public class Circle implements ICircle{
	public double radius;

	public Circle() {
	}

	@Override
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