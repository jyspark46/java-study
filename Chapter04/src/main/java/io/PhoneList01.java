package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PhoneList01 {

	public static void main(String[] args) {
		
		try {
			// 기반 스트림
			File file = new File("./phone.txt"); // 예외를 미리 처리해주기 위해
			
			if(file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			FileInputStream fis = new FileInputStream(file);
			fis.read();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 보조 스트림

	}

}
