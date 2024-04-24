package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		
		goods.name = "camera";
		
		// protected: 같은 패키지에서 접근 가능
		// 더 중요하게 따져봐야 하는 것은 자식에서 접근이 가능하다는 것.
		//goods.price = 20000;
		
		// default: 같은 패키지에서 접근 가능
		//goods.countStock = 10;
		
		// private: 내부에서만 접근 가능
		//goods.countSold = 20;
	}

}
