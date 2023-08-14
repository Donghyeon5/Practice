package java_study.Pratice3.Pen;

public class pen {
	private int amount; // 잔여량
	private int width; // 펜의 굵기

	public pen() {
	}

	public pen(int amount, int width) { // pen 클래스의 매개변수 초기화, amount,width
		this.amount = amount;
		this.width = width;
	}

	public String getInfo() { // 잔여량과 굵기 정보 얻는 메서드
		return "잔여량 : " + amount + ", 펜의 굵기 : " + width;
	}

	public void refill(int amount) { // 리필 메서드
		this.amount = amount + amount;
	}

	// get, set method
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
