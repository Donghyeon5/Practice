package Pratice1;

public class Tv extends Product{ //Product 클래스 상
	
	public Tv() {
		super(100); //부모 클래스의 생성자에 100 매개변수 투입.
	}
	
	@Override
	public String toString() {
		return "Tv";  //toString 클래스의 기능을 return Tv 기능으로 오버라이드 
	}
	
}
