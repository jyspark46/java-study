package chpater04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
	}

	private static void printDate01(Date now) {
		// TODO Auto-generated method stub
		// 2024-04-29 13:10:20 formatting
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(now);
		System.err.println(date);
	}
	
	private static void printDate02(Date now) {
		// TODO Auto-generated method stub
		// 년도 --> +1900 해야 함
		int year = now.getYear();
		
		// 월 --> 0 ~ 11, +1 해야 함
		int month = now.getMonth();
		
		// 일
		int day = now.getDate();
		
		// 시
		int hours = now.getHours();
		
		// 분
		int minutes = now.getMinutes();
		
		// 초
		int seconds = now.getSeconds();
		
		System.out.println(
		(year + 1900) + "-" + 
		(month + 1) + "-" + 
		day + " " + 
		hours + ":" + 
		minutes + ":" + 
		seconds);
	}

}
