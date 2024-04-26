package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new MyClass().danger();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println("Error: " + e);
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}
	}

}
