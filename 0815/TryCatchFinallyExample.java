package java_study.chapter10;

public class TryCatchFinallyExample {

	public static void main(String[] args) {

		try {
			Class clazz = Class.forName("java.lang.String");
			System.out.println(clazz);

		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않음.");

		} finally {
			System.out.println("오류 실행 실험 끝");
		}
		System.out.println("프로그램 종료 !!!");

	}
}
