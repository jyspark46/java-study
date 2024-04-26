package exception;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L; // 안해도 상관 X
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException() {
		super("MyException Thrown");
	}

}
