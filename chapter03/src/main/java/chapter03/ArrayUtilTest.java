package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10, 20, 30, 40};
		
		double[] d = ArrayUtil.intToDouble(a);
		System.out.println(Arrays.toString(d));
	}

}
