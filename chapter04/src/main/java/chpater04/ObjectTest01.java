package chpater04;

public class ObjectTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point = new Point();
		
		Class klass = point.getClass(); // reflection
		System.out.println(klass.toString());
		
		System.out.println(point.hashCode()); // address 기반의 hashing value
											  // address X
											  // reference X
		
		System.out.println(point.toString()); // getClass().toString() + "@" + hashCode()
		System.out.println(point);
	}

}
