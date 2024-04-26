package prob02;

public class Book {

	int bookNo;
	String title;
	String author;
	int stateCode = 1;

	public Book(int bookNo, String title, String author) {
		// TODO Auto-generated constructor stub
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}
	
	public void rent() {
		this.stateCode = 0;
	}

	public void print() {
		if(this.stateCode == 0) {
			System.out.println(
					"책 번호: " + this.bookNo +
					", 책 제목: " + this.title + 
					", 작가: " + this.author + 
					", 대여 유무: 대여중");
		}
		else {
			System.out.println(
					"책 번호: " + this.bookNo +
					", 책 제목: " + this.title + 
					", 작가: " + this.author + 
					", 대여 유무: 재고있음");
		}
	}
}
