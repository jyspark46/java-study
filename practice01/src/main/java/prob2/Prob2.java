package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int start = 1;
		int increase = 0;
		
		for(int i = 0; i < 9; i++) {
			increase = start;
			for(int j = 0; j < 10; j++) {
				System.out.print(increase + " ");
				increase++;
			}
			start++;
			System.out.println();
		}
	}
}
