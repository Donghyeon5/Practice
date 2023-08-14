package java_study.Pratice3.Pen;

public class BallPen extends pen {
	private String color;

	public BallPen() {
	}

	public BallPen(int amount, int width, String color) {
		super(amount, width);
		this.color = color;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + ", 색상 : " + color;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
