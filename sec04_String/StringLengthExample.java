package java_study.chapter11.sec04_String;

public class StringLengthExample {

	public static void main(String[] args) {
		String ssn = "9605031111111";
		int length = ssn.length();

		if (length == 13) {
			System.out.println("주민번호 자리 수 가 맞습니다.");
		} else {
			System.out.println("주민번호 자리 수가 틀립니다.");
		}

	}

}
