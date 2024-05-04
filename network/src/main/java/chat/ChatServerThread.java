package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	
	public ChatServerThread(Socket socket, List<Writer> listwriters) {
		this.socket = socket;
		this.listWriters = listwriters;
	}
	
	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		
		// 1. Remote Host Information
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			// 2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			// 3. 요청 처리
			while(true) {
				String request = br.readLine(); // blocking
				
				if(request == null) {
					ChatServer.log("closed by client");
					break;
				}
				
				// 4. 프로토콜 분석			
				String[] tokens = request.split(":");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);
					pw.println(tokens[1]);
				} else {
					ChatServer.log( "error: unknown request(" + tokens[0] + ")" );
				}
			}
		} catch(SocketException e) {
			doQuit(pw);
			ChatServer.log("Socket Exception: " + e);
		} catch(IOException e) {
			ChatServer.log("error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doJoin(String nickname, Writer writer) {
		
		this.nickname = nickname;
		String data = nickname + "님이 참여하였습니다.";
		
		// writer pool에 저장
		addWriter(writer);
		broadcast(data);
		
		// ack
		PrintWriter pw = (PrintWriter) writer;
		pw.println("입장하였습니다. 즐거운 채팅 되세요.");
		//pw.flush();

	}

	private void addWriter(Writer pw) {
		
		synchronized(listWriters) {
			listWriters.add(pw);
		   }
		
	}

	private void doMessage(String message) {
		
		broadcast(nickname + ":" + message);
		
	}
	
	private void doQuit(Writer writer) {
		
		removeWriter(writer);
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);

	}

	private void broadcast(String data) {
		
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}

	}

	private void removeWriter(Writer pw) {
		
		synchronized(listWriters) {
			listWriters.remove(pw);	
		}
		
	}
}