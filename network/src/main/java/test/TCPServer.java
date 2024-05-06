package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 1.1 FIN_WAIT2 -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위함
			serverSocket.setReuseAddress(true);
			
			// 2. 바인딩 (binding)
			// Socket에 InetSocketAddress[InetAddress(IPaddress) + Port] 를 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);
			// 0.0.0.0 : 어떤 IP 주소로 들어와도 됨(특정 호스트 IP를 바인딩 하지 X)
			// 10: accept 기간 동안 Queue의 길이 -> 10개 정도면 충분
		
			// 3. accept
			Socket socket = serverSocket.accept(); // --> 코드가 멈추고 더 이상 진행 X (blocking)
			
			// DATA 부분 시
			try {
				
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				
				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. read data - 바이트 단위 !!
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					
					if(readByteCount == -1) {
						// 클라이언트가 정상적으로 종료 - close() 호출
						System.out.println("[server] closed by client.");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: " + data);
					
					// 6. write data - 바이트 단위 !!
					os.write(data.getBytes("UTF-8"));
					
					
				}
				
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client." + e);
			} catch(IOException e) {
				System.out.println("[server] error: " + e);
			} finally {
				try {
					
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			// DATA 부분 끝
			
			//System.err.println("연결 !!!");
			
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed()) { // 두 번 닫으면 에러가 생기기 때문에
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
