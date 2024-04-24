package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int number = 0;
		int sum;
		
		for(int i = 0; i < 3; i++) {
			sum = 0;
			System.out.println("숫자를 입력하세요: ");
			number = scanner.nextInt();
			
			if(number % 2 == 0) {
				for(int j = 0; j <= number; j+=2)
					sum += j;
				
				System.out.println(sum);
			}
			
			else {
				for(int k = 1; k <= number; k+=2)
					sum += k;
				
				System.out.println(sum);
			}
				
		}
		
		scanner.close();
	}
}
