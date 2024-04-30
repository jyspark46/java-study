package chpater04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}
	
	// 상황에 따라 수정할 수 있어야 함
	@Override
	public int hashCode() {
		return Objects.hash(h*w);
	}
	
	// 상황에 따라 수정할 수 있어야 함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return h * w == other.h * other.w;
	}

}
