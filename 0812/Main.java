package Pratice1;

public class Main {

	public static void main(String[] args) {
		
		Buyer donghyeon = new Buyer(); // 바이어 클래스의 donghyeon 이름을 가진 인스턴스 생성 
		
		donghyeon.buy(new Tv());
		donghyeon.buy(new Computer());
		donghyeon.cart();
		donghyeon.showInfo();

	}

}
	