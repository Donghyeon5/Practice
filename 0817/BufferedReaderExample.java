package java_study.chapter13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample {

	public static void main(String[] args) {

		try (InputStream is = System.in;
				Reader reader = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(reader);) {
			System.out.print("입력 : ");
			String lineString = br.readLine();
			System.out.println("출력 : " + lineString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
//public static void main(String[] args) {
//	long start = 0;
//	long end = 0;
//
//	try (FileInputStream fis1 = new FileInputStream("C:/temp/programming.jpg");) {
//		start = System.currentTimeMillis();
//		while (fis1.read() != -1) { // 한 바이트씩 읽겠다.
//		}
//		end = System.currentTimeMillis();
//		System.out.println("사용하지 않았을때 : " + (end - start) + "ms");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}