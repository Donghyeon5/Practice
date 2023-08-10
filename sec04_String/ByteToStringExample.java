package java_study.chapter11.sec04_String;

public class ByteToStringExample {

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 }; // ASCII 코드

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4); // 6번째로부터 뒤로 4개까지만 변환
		System.out.println(str2);
	}

}
