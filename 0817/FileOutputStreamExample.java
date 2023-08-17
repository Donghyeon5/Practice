package java_study.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {

	public static void main(String[] args) throws Exception {

		String originalFileName = "C:/temp/dog.jpg";
		String targetFileName = "C:/temp/dog_copy.jpg";

		try (FileInputStream fis = new FileInputStream(originalFileName);
				FileOutputStream fos = new FileOutputStream(targetFileName);) {

			int readByteNo;
			byte[] readBytes = new byte[100];
			while ((readByteNo = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteNo);
			}
			fos.flush();
			System.out.println("복사완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

//try (FileInputStream fis = new FileInputStream("C:/temp/test.txt")) {
//
//	int data;
//	while ((data = fis.read()) != -1) { // 1byte씩 읽고 콘솔에 출력
//		System.out.write(data); // 있는 그대로, 읽어내는 그대로 출력
//		// System.out.println(data); -> 바이너리타입과 맞지않음, 텍스트 출력(o)
//	}
//	System.out.flush(); // 엔터치지 않았어도 마지막 전체 출력
//} catch (Exception e) {
//	e.printStackTrace();
//
//}
//
//}
