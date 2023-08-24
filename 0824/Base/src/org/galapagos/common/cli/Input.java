package org.galapagos.common.cli;

import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);

	// Facade Pattern
	public static String read(String title) { // 리턴 타입, 함수명(변수 타입 변수 이름)
		System.out.print(title);
		return sc.nextLine();
	}

	public static String read(String title, String defaultValue) {
		// 이름(김길동) :
		System.out.printf("%s(%s) : ", title, defaultValue);
		String answer = sc.nextLine();

		// 그냥 엔터 치면 defaultValue 리턴, 입력값이 있으면 answer 리턴
		return answer.isEmpty() ? defaultValue : answer;

	}

	public static int readInt(String title) {
		System.out.print(title);
		int answer = sc.nextInt();
		sc.nextLine(); // 엔터 제거용
		return answer;
	}

	public static boolean confirm(String title) {
		return confirm(title, true);
	}

	public static boolean confirm(String title, boolean defaultValue) {
		String yesNo = defaultValue ? "(Y/n)" : "(y/N)";
		System.out.printf("%s %s: ", title, yesNo);

		String answer = sc.nextLine();
		if (answer.isEmpty())
			return defaultValue;

//		if (answer.equalsIgnoreCase("y")) {
//			return true;
//		} else {
//			return false;
//		}

		return answer.equalsIgnoreCase("y");

		// return answer.isEmpty()) ? defaultValue : answer.equalsIgnoreCase("y");
	}

}
