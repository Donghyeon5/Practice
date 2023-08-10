package java_study.chapter11.sec04_String;

import java.util.Scanner;

public class Mp3Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("파일명을 입력 >>");

		String fileName = sc.next(); // 파일명 입력받기

		String test = fileName.toLowerCase(); // 소문자로 일괄적으로 변경
		if (test.endsWith("mp3")) { // 확장자명 비교하기
			System.out.println("음악 파일 입니다.");
		} else {
			System.out.println("음악 파일이 아닙니다.");
		}
	}

}
