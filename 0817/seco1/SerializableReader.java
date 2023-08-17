package java_study.chapter13.seco1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableReader {

	public static void main(String[] args) {

		try {
			ClassA v = (ClassA) Serializer.load("c:/temp/object2.dat");

			System.out.println("field1 : " + v.field1);
			System.out.println("field2.field1 : " + v.field2.field1);

			System.out.println("field3 : " + v.field3);
			System.out.println("field4 : " + v.field4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object load(String filePath) throws Exception {
		// 예외 처리는 호출한 쪽에서 처리
		// 닫기(close)만 자동화
		try (FileInputStream fis = new FileInputStream(filePath); ObjectInputStream ois = new ObjectInputStream(fis);) {
			return ois.readObject();
		}

	}
}

//public static void main(String[] args) {
//	try (FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
//			ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//		ClassA v = (ClassA) ois.readObject(); // 인스턴스 복원
//
//		System.out.println("field1 : " + v.field1);
//		System.out.println("field2.field1 : " + v.field2.field1);
//		// 직렬화에서 제외 되었으므로 기본값 가진다.
//		System.out.println("field3 : " + v.field3);
//		System.out.println("field4 : " + v.field4);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//}
