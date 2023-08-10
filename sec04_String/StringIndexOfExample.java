package java_study.chapter11.sec04_String;

public class StringIndexOfExample {

	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		if (subject.indexOf("자바") != -1) { // 특정 단어가 있는지 없는지 체크
			System.out.println("자바와 관련된 책이군요!");
		} else {
			System.out.println("자바와 관련없는 책이군요!");
		}

	}

}
