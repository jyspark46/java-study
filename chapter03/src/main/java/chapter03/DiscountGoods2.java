package chapter03;

public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		// protected: 자식 클래스에서 접근 가능
		return discountRate * price;
	}
}
