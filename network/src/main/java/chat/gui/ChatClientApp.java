package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		try {
			
			// socket 생성
			socket = new Socket();
			// socket 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			// enter chatroom
			while( true ) {
				
				System.out.println("대화명을 입력하세요.");
				System.out.print(">> ");
				name = scanner.nextLine();
				
				if (!name.isEmpty()) {
					break;
				}
				
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
				
			}
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream() , "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// join protocol
			pw.println("join:" + name);
			
			String input = br.readLine(); //blocking
			
			if(input.equals("join:ok")) {
				System.out.println("입장하셨습니다. 즐거운 채팅되세요.");
			}
			
			new ChatWindow(socket, name).show();
			
		} catch(SocketException e) {
			log("Socket:" + e);
		} catch(IOException e) {
			log("error:" + e);
		} finally {
				scanner.close();
		}
	}
	
	public static void log(String message) {
		System.out.println("[ChatClientApp] " + message);
	}
}