package java_study.chapter11.sec04_String;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn = "960503-1234567";

		String firstNum = ssn.substring(0, 6);
		String secondNum = ssn.substring(7);

		System.out.println(firstNum);
		System.out.println(secondNum);

		String fileName = "Hello.World.mp3";
		int lastDot = fileName.lastIndexOf('.');// 마지막 점의 위치 찾기
		if (lastDot != -1) {
			String ext = fileName.substring(lastDot + 1); // 마지막 점 위치+1 부터 끝까지 추출
			System.out.println(ext); // ext 확장명

			// 확장명을 제외한 파일명만 추출
			String baseName = fileName.substring(0, lastDot);
			System.out.println(baseName);
		}

	}

}
