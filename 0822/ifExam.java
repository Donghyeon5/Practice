package java_study.funjava.D0822;

public class ifExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		// 3항 연산자
		int value = (a > 5) ? 20 : 30;
		System.out.println(value);

		int b = 30;
		int value2 = (a < 50) ? 30 : 50;
		System.out.println(value2);

		int num = 1;
		switch (num) { // break가 없는 경우 위에서 밑으로 계속 시행
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default:
			System.out.println("1,2,3이 아닙니다.");
		}

		String gamja = "감자";
		switch (gamja) {
		case "감자":
			System.out.println("감자입니다.");
			break;
		default:
			System.out.println("감자가 아닙니다!");
		}

		// while(탈출 조건식){ -> 탈출 조건식이 true이면 무한 루프, false이면 중단
		// 탈출 조건식이 참일 경우 시행되는 코드
		// 변수의 증감식}

		int y = 1;
		while (y < 7) {
			System.out.println(y);
			y++;
		}
		// k가 11일때 중단되는 무한루프식
		int k = 1;
		while (true) {
			if (k == 10) {
				break;
			}
			System.out.println(k);
			k++;
		}

		int u = 0;
		while (u++ < 10) {
			System.out.println(u);
		}

		// 1- 10까지의 짝수만 출력 ,continue를 만나게 되면 실행하지않고 다시 반복
//		int t = 0;
//		while (t++ < 10) {
//			if (t % 2 != 0)
//				continue;
//			System.out.println(t);
//		}
		int t = 0;
		while (t++ < 10) {
			if (t % 2 != 0)
				continue;
			System.out.println(t);
		}

	}

}
