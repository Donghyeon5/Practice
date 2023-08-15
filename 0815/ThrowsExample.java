package java_study.chapter10;

public class ThrowsExample {

	public static void main(String[] args) {

		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 후속 작업, fondclass가 성공했다는 가정안에 실행,
	}

	public static void findClass() throws ClassNotFoundException { // 예외던지기~!
		Class clazz = Class.forName("java.lang.String2");
	}

}
