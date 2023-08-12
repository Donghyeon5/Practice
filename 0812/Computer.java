package Pratice1;

public class Computer extends Product {
	
	public Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";  //toString 클래스의 기능을 return Tv 기능으로 오버라이드 
	}
	
}
