package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	
	public static final int PORT = 6000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		
		try {

			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);

			Socket socket = serverSocket.accept(); // blocking
			
			try {
				
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// 새로운 부분
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // true: Autoflush(buffer가 다 안차도 넘김)를 위해 사용
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				
				while(true) {

					String data = br.readLine(); // blocking
					
					if(data == null) {
						log("closed by client.");
						break;
					}
					
					log("received: " + data);
					
					pw.println(data);
					os.write(data.getBytes("UTF-8"));
					
				}
				
			} catch(SocketException e) {
				log("suddenly closed by client." + e);
			} catch(IOException e) {
				log("error: " + e);
			} finally {
				try {
					
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}