package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		try {
			// 기반 스트림
			File file = new File("phone.txt"); // 예외를 미리 처리해주기 위해
			
			if(file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + " Bytes");
			// Date d = new Date(file.lastModified());
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("=== 전화번호 ===");
			
			// 1. 기반 스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조 스트림02 (byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			
			// 3. 보조 스트림03 (char|char|char\n -> "charcharchar" (string))
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				// System.out.println(line); // 테스트용
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					
					if(index == 0) { // 이름
						System.out.print(token + ":");
					} else if(index == 1) { // 전화번호1
						System.out.print(token + "-");
					} else if(index == 2) { // 전화번호2
						System.out.print(token + "-");
					} else { // 전화번호 3
						System.out.println(token + "\n");
					}
						
					index++;
				}
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

}
