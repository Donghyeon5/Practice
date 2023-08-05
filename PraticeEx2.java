package java_study.chapter04;

import java.util.Scanner;

public class PraticeEx2 {

	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) { // *10개를 10번씩 반복!!
			for (int j = 1; j < 11; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

		System.out.println("---------------------------------------------------");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*"); // 1 대입후, 조건종료 출력 / 2대입후 1,2까지 출력후 종료,출력 / 3 대입후 1,2,3까지 출력후 종료, 출력...
			}
			System.out.println();
		}

		System.out.println("---------------------------------------------------");

		System.out.print("*를 출력할 라인의 수를 입력하세요. > ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("---------------------------------------------------");

		for (int i = 1; i < 10; i++) {
			int x2 = 2 * i;
			System.out.println("2 X " + i + " = " + x2);
		}

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %d%n", i, j, i * j);
			}
		}

	}

}
