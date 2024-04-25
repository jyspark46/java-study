package chapter03;

public class SongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song01 = new Song("좋은 날", "아이유", "real", "이민수", 3, 2010);
//		song01.setTitle("좋은 날");
//		song01.setArtist("아이유");
//		song01.setAlbum("real");
//		song01.setComposer("이민수");
//		song01.setTrack(3);
//		song01.setYear(2010);
		song01.show();
		
		Song song02 = new Song("Ditto", "New Jeans");
		song02.show();
	}

}
