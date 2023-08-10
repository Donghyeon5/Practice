package java_study.chapter11.sec04_String;

public class StringReplaceExample {

	public static void main(String[] args) {
		String oldstr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 제공합니다.";
		String newStr = oldstr.replace("자바", "JAVA");

		System.out.println(oldstr);
		System.out.println(newStr);
	}

}
