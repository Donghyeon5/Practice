package java_study.Pratice1;

public class main {

	public static void main(String[] args) {
		Buyer Kim = new Buyer();

		Kim.buy(new Television());
		Kim.buy(new Computer());
		Kim.showInfo();
	}

}
