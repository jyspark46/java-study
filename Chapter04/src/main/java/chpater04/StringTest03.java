package chpater04;

public class StringTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/// String s1 = "Hello " + "World" + " java" + 17;
		
		String s1 = new StringBuffer("Hello ")
					.append("World")
					.append(" java")
					.append(17)
					.toString();
		
		String s2 = new StringBuilder("Hello ")
				.append("World")
				.append(" java")
				.append(17)
				.toString();
		
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = "";
		for(int i = 0; i < 1000000; i++) {
			//s3 += "h";
			//s3 = new StringBuffer(s3).append("h".toString());
		}
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			//s3 += "h";
			sb.append("h");
		}
		String s4 = sb.toString();
		
	}

}
