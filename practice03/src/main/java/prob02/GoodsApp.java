package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] data = line.split(" ");
			
			String name = data[0];
			int price = Integer.parseInt(data[1]);
			int count = Integer.parseInt(data[2]);
			
			goods[i] = new Goods(name, price, count);
		}

		// 상품 출력
		for(int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(
					goods[i].getName() + "(가격:" + 
					goods[i].getPrice() + "원)이 " + 
					goods[i].getCount() + "개 입고 되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}
