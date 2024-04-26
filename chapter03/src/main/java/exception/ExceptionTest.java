package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10 - a;
		
		System.out.println("Some code1...");
		
		try {
			System.out.println("Some code2...");
			System.out.println("Some code3...");
			
			int result = (1 + 2 + 3) / b; // b = 0 일 때 예외 발생 가능
			
			System.out.println("Some code4...");
			System.out.println("Some code5...");
			
		} catch(ArithmeticException ex) {
			/* 예외 처리 */
			// ex.printStackTrace();
			// 1. 로깅
			System.out.println("Error: " + ex);
			
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상 종료
			// System.exit(0);
			return;
		} finally {
			System.out.println("자원 정리: ex) close file, socket, db connection.");
		}
		
		System.out.println("Some code6...");
		System.out.println("Some code7...");
		
//		System.out.println(result);
	}

}
