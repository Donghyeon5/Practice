package java_study.Pratice1;

public class Buyer {

//	int Money = 1000;
//	int Bonus = 0;
//
//	public Buyer() {
//	}
//
//	public void buy(Product Zzz) {
//		if (Money < Zzz.price) {
//			System.out.println("잔액이 부족합니다.");
//			return;
//		}
//		Money = Money - Zzz.price;
//		Bonus = Zzz.bonus;
//
//		System.out.println(Zzz + " 을(를) 구매 하셨습니다.");
//
//	}
//
//	public void showInfo() {
//		System.out.println("현재 남은 금액은 " + Money + "만원 입니다.");
//		System.out.println("현재 보너스는 " + Bonus + "점 입니다.");
//	}

	int Money = 1000;
	int Bonus = 0;

	public Buyer() {
	}

	public void buy(Product Zzz) {
		if (Money < Zzz.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		Money = Money - Zzz.price;
		Bonus = Zzz.bonus;

		System.out.println(Zzz + "을(를) 구매하셨습니다.");

	}

	public void showInfo() {
		System.out.println("현재 남은 금액은 " + Money + "만원 입니다.");
		System.out.println("현재 보너스는 " + Bonus + "점 입니다.");
	}
}
