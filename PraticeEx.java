package java_study.chapter04;

public class PraticeEx {

	public static void main(String[] args) {

		for (int i = 1; i < 11; i++) {
			int sum = 0;
			sum = sum + i;
			// i를 sum에 누적하여 더한다.
			System.out.println("1부터 " + i + "까지의 합 : " + sum);
		}

		for (int i = 1, j = 10; i < 11; i++, j--) { // 2개의 변수를 반복문 하나로
			System.out.printf("%d \t %d%n", i, j); // %n 줄바꿈
		}
		System.out.println("---------------------------------------------------");
		System.out.println("i \t 2*i \t 2*i-1 \t i*i \t 11-i \t i%3 \t i/3");
		System.out.println("---------------------------------------------------");

		for (int i = 1; i < 11; i++) {

			System.out.printf("%d \t %d \t %d \t %d \t %d \t %d \t %d%n", i, 2 * i, 2 * i - 1, i * i, 11 - i, i % 3,
					i / 3);

		}

	}

}
