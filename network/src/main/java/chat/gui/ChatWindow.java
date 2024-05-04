package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {
	
	private Socket socket;
	private String name;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
		
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		
		try {
			this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		} catch (UnsupportedEncodingException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
					
		// ChatClientThread 생성
		new ChatClientThread(socket).start();
		updateTextArea("입장하였습니다. 즐거운 채팅 되세요.");
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		if("quit".equals(message) == true) {
			// quit protocol
			finish();
		} else {
			// message protocol
			pw.println("message:" + message);
		}
		
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		pw.println("quit");
		
		// exit java application
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread {
		
		private Socket socket;
		
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {			
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				String message = null;
				
				while(true) {
					message = br.readLine(); // blocking
					
					if(message == null) {
						break;
					}
					
					updateTextArea(message);
				}
			} catch(SocketException e) {
				//e.printStackTrace();
			} catch(IOException e) {
				//e.printStackTrace();
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
	}
	
	public static void log(String message) {
		System.out.println("[ChatWindow] " + message);
	}
}