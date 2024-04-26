package prob05;

public class Base {
	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else {
			night();
		}
	}
	
	public void day(){
		System.out.print("낮");
	}
	
	public void night(){
		System.out.println("night");
	}
}
