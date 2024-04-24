package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			//System.out.println(correctNumber);
			int i = 1;
			int input = 0;
			int start = 1;
			int end = 100;

			while(true) {
				System.out.println(start + "-" + end);
				System.out.print(i + ">>");
				input = scanner.nextInt();
				
				if(input == correctNumber) {
					System.out.println("맞았습니다.");
					break;
				}
				
				else if(input < 0 || input > 100) {
					start = start;
					end = end;
				}
				
				else {
					
					if(input > correctNumber) {
						System.out.println("더 낮게");
						end = input;
					}
					
					else {
						System.out.println("더 높게");
						start = input;
					}
					
				}
				
				i++;
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}