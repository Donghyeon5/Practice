package org.galapagos.mcmorning.cli;

import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);

	// Facade Pattern
	public static String read(String title) { // 리턴 타입, 함수명(변수 타입 변수 이름)
		System.out.print(title);
		return sc.nextLine();
	}
}
