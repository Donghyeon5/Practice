package Pratice1;

public class Product { // Proucct 클래스(설계도)

	
	int price; //제품 가격 타입 선언	
	int bonusPoint; //보너스 포인트 타입 선언
	
	public Product() {} // 기본생성자 생성, 매개변수 초기화 	
	public Product(int price) {  // 제품 가격을 매개변수로 받아와 본 클래스의  제품 가격에 저장한다.
		this.price = price;
		bonusPoint = (int)(price /10); //매개변수가 있는 생성자를 통해 생성한 객체에서 바로 보너스점수를 계산하여 저장한다.


	}
}
	
	
	


