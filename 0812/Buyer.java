package Pratice1;

public class Buyer {
	int Money = 1000; //보유 금액
	int bonusPoint = 0; //보너스 포인트
	
	Product[] item = new Product[10]; //product 타입의 길이가 10인 "item" 배열
	int idx=0; // item 배열의 초기화 ,0 
	
	
	public Buyer() {} //기본 생성자
	public void buy(Product p) { // buy 메소드 -> Product 타입의 p를 변수로 삼
		if(Money < p.price) { // 만약 p의 가격보다  보유 금액이 크다
			System.out.println("잔액이 부족합니다.");
			return;}
		
			Money -= p.price;
	        bonusPoint = p.bonusPoint;
			
			item[idx++] = p;  //item 배열을 구성 , 구매한 제품p 를 아이템 배열에 추가 
	        System.out.println( p + "을(를) 구입하셨습니다.");
		}
	
	
	 void showInfo() {
	        System.out.println("현재 남은 금액은 " + Money + "만원 입니다.");
	        System.out.println("현재 보너스 점수는 " + bonusPoint + "점 입니다.");
	    }
	


	void cart() {
	    int sum = 0; 
	    String itemList = "";
	    
	    for (int i=0; i<item.length; i++) {
	        if (item[i] == null) break; //아이템 배열이 더 없으면 중단  
	        
	        sum += item[i].price;  //가격 합
	        itemList += (i==0) ? item[i] : ", " + item[i]; 
	    }
	    
	    System.out.println("총 금액은 " + sum + "만원 입니다.");
	    System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

	

