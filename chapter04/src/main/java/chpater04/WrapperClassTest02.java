package chpater04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		
		String s = "123456";
		int i = Integer.parseInt(s);

		// cf1) 반대로
		String s1 = String.valueOf(i);
		
		// cf2) 반대로
		String s2 = "" + i;
		
		System.out.println(s + ":" + s1 + ":" + s2);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		// cf3) ASCII 코드값
		char c = 'A';
		System.out.println((int)c);
		
		// cf4) 2진수로 변환
		String s41 = Integer.toBinaryString(-15);
		String s42 = Integer.toBinaryString(15);
		System.out.println(s41 + ":" + s42);
		
		// cf5) 16진수로 변환
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}

}
