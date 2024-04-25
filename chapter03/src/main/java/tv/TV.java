package tv;

public class TV {
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power; 
	
	public TV(int i, int j, boolean b) {
		// TODO Auto-generated constructor stub
		this.channel = i;
		this.volume = j;
		this.power = b;
	}

	public void status() {
		if(power) {
			System.out.println(
					"TV [ channel = " + channel + 
					", volume = " + volume + 
					", power = on ]");
		}
		else {
			System.out.println(
				"TV [ channel = " + channel + 
				", volume = " + volume + 
				", power = off ]");
		}
		
	}

	public void power(boolean on) { // 메소드 구현
		this.power = on;
	}

	public void channel(int channel) { // 메소드 구현 (1~255 유지)
		if(channel < 0) {
			this.channel = 255;
		}
		
		if(channel > 255) {
			this.channel = 1;
		}
		
		else {
			this.channel = channel;
		}
	}

	public void channel(boolean up) { // 메소드 오버로딩 (1~255 유지, 1씩 증감)
		if(up) {
			if(channel > 255) {
				this.channel = 1;
			}
			
			else {
				channel += 1;
			}
		}
		else {
			if(channel < 1) {
				this.channel = 255;
			}

			else {
				channel -= 1;
			}
		}
	}

	public void volume(int volume) { // 메소드 구현 (0 ~ 100 유지)
		if(volume < 0) {
			this.volume = 100;
		}
		
		if(volume > 100) {
			this.volume = 0;
		}
		
		else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) { // 메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
		if(up) {			
			if(volume > 100) {
				this.volume = 0;
			}
			
			else {
				volume += 1;
			}
		}
		else {
			if(volume <= 0) {
				this.volume = 100;
			}
			
			else {
				volume -= 1;
			}
		}
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

}
