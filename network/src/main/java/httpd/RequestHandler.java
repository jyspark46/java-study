package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			
			// 테스트 이후 1 - buffer reader 객체 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
					
			// 테스트 이후 2 - read
			String request = null;
			
			while(true) {
				String line = br.readLine();
				
				// 브라우저에서 연결을 끊으면...
				if(line == null) {
					break;
				}
				
				// SimpleHttpServer는 HTTP Header만 처리
				if("".equals(line)) {
					break;
				}
				
				// request header의 첫 줄만 읽음
				if(request == null) {
					request = line;
					break;
				}
			}
			
			// 요청 처리
			consoleLog(request);
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				// methods: POST, PUT, DELETE, HEAD, CONNECT
				// SimpleHttpServer 에서는 무시(400 Bad Request)
				response400Error(outputStream, tokens[2]);
			}
		} catch(Exception ex) {
			consoleLog( "error:" + ex );
		} finally {
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
			
		// default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		
		// nio: 
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		// 예제 응답입니다.
		// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
		// 테스트 끝 !!
		outputStream.write((protocol + " 200 OK\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	
	}
	
	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		
		/*// default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}*/
		String url = "/error/400.html";
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		
		// nio: 
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		// 예제 응답입니다.
		// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
		// 테스트 끝 !!
		outputStream.write((protocol + " 400 Bad Request\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
		
	}

	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		
		/*// default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}*/
		String url = "/error/404.html";
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			response400Error(outputStream, protocol);
			return;
		}
		
		// nio: 
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		// 예제 응답입니다.
		// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
		// 테스트 끝 !!
		outputStream.write((protocol + " 404 Bad Request\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
		
	}
	
	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}

