package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName(); // 컴퓨터(디바이스) 이름
			String hostIpAddress = inetAddress.getHostAddress(); // IP 주소
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetAddress.getAddress(); // 바이트로 받아옴
			for(byte IpAddress : IpAddresses) {
				System.out.println(IpAddress & 0x000000ff);
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
