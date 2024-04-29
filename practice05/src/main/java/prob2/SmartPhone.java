package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		// TODO Auto-generated method stub
		if(function.equals("음악")) {
			playMusic();
		}
		else if(function.equals("앱")) {
			start();
		}
		else {
			super.execute(function);
		}
	}
	
	@Override
	protected void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("다운로드해서 음악 재생");
	}

	private void start(){
		System.out.println( "앱 실행" );
	}
	
}
