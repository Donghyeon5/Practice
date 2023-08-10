package java_study.chapter11.sec04_String;

public class StringCharAtExample {

	public static void main(String[] args) {
		String ssn = "960503-1111111";
		char sex = ssn.charAt(7);
		switch (sex) {
		case '1': // : or 이라는 뜻
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}

	}

}
