package prob3;

public class Sparrow extends Bird {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("참새(" + toString() + ")가 날아 다닙니다.");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("참새(" + toString() + ")가 소리내어 웁니다.");
	}

	@Override
	public String toString() {
		return name;
	}

}
