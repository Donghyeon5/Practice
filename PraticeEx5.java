package java_study.chapter04;

public class PraticeEx5 {

	public static void main(String[] args) {

		int[] numArr = new int[10];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]);
		} // 1~10까지의 정상적인 수 배열
		System.out.println();
		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10);
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		// 첫번째 배열과 임의번째 배열의 숫자를 변경, 100회 수행, 완전히 랜덤값으로 변경
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}

		// 출력
		System.out.println();
		System.out.println("---------------------------------------------------");

		int[] ball = new int[45];
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
			System.out.print(ball[i]);
		}

		for (int i = 0; i < 6; i++) {
			int random = (int) (Math.random() * 45);
			int dummy = 0;
			dummy = ball[i];
			ball[i] = ball[random];
			ball[random] = dummy;
		}
		for (int i = 0; i < 7; i++) {
			System.out.printf("ball[%d]=%d%n", i, ball[i]);
		}
	}

}
