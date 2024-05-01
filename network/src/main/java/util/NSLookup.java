package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		
		try {
			
			InetAddress[] inetAddress = InetAddress.getAllByName("www.naver.com"); // 입력받는 건 추후 구현
			
			for(InetAddress ia : inetAddress) {
				System.out.println(ia);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
