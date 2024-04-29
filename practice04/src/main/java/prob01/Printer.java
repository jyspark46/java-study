package prob01;

public class Printer {

//	public void println(int intNum) {
//		// TODO Auto-generated method stub
//		System.out.println(intNum);
//	}
//	
//	public void println(boolean bool) {
//		// TODO Auto-generated method stub
//		System.out.println(bool);
//	}
//	
//	public void println(double doubleNum) {
//		// TODO Auto-generated method stub
//		System.out.println(doubleNum);
//	}
//	
//	public void println(String str) {
//		// TODO Auto-generated method stub
//		System.out.println(str);
//	}
	
	/*// Generic 예시 !!! --> int i = println("hello", 1);
	public <T, S> T println(T t, S s) {
		System.out.println(t);
		return t;
	}*/
	
	// Generic 예시 !!! --> Overloading 안해도 됨 !!
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}

	public int sum(Integer... nums) {
		// TODO Auto-generated method stub
		int s = 0;
		for(Integer n : nums) {
			s += n;
		}
		
		return s;
	}
	

}
