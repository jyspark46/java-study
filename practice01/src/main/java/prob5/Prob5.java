package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int number;
		int count;
		
		for(number = 1; number < 100; number++) {
			String str = String.valueOf(number);
			count = 0;
			
			if(number < 10) {
				char c1 = str.charAt(0);
				
				if(c1 % 3 == 0)
					System.out.println(number + " 짝");
			}
			
			else {
				char c1 = str.charAt(0);
				char c2 = str.charAt(1);
				
				if(c1 % 3 == 0)
					count++;
				if(c2 % 3 == 0 & c2 != '0')
					count++;
				
				if(count == 1)
					System.out.println(number + " 짝");
				if(count == 2)
					System.out.println(number + " 짝짝");
			}	
		}
	}
}
