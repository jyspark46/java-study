package prob6;

public class Rectangle extends Shape implements Resizable {
	
	private double width;
	private double height;

	public Rectangle(int i, int j) {
		// TODO Auto-generated constructor stub
		this.width = i;
		this.height = j;
	}

	@Override
	public void resize(double a) {
		// TODO Auto-generated method stub
		this.width *= a;
		this.height *= a;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (this.width + this.height) * 2;
	}

}
