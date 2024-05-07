package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	
	public static final int PORT = 6000;
	public static final int BUFFER_SIZE = 256;

	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		try {
			// 1. 소켓 생성
			socket = new DatagramSocket(PORT);
			
			while(true) {
				// 2. 데이터 수신
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				// receive
				socket.receive(rcvPacket); // blocking - receive 자체가 blcoking -> thread 모델로 만들려면 lock을 걸어줘야 함
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				
				// byte로 받기 때문에 String으로 Encoding
				String message = new String(rcvData, 0, offset, "UTF-8");
				// 내용 출력
				System.out.println("[UDP Echo Server] received: " + message);
				
				// 3. 데이터 송신
				byte[] sndData = message.getBytes("UTF-8");
				// 파라미터: 내용, 내용의 길이, 받는 사람 주소(보내는 사람 주소는 자동), 받는 사람 포트
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(), rcvPacket.getPort()); 
				// send
				socket.send(sndPacket);
			}
				
		} catch (SocketException e) {
			System.out.println("[UDP Echo Server] error: " + e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}
}