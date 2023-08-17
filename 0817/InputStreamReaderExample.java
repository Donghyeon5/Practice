package java_study.chapter13;

import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//
//		int readCharNo;
//		char[] cbuf = new char[100];
//		while ((readCharNo = reader.read(cbuf)) != -1) {
//			String data = new String(cbuf, 0, readCharNo);
//			System.out.println(data);
//		}
//
//		reader.close();
//	}

		try (Reader reader = new InputStreamReader(System.in);) {
			int readCharNo;
			char[] cbuf = new char[100];
			while ((readCharNo = reader.read(cbuf)) != -1) {
				String data = new String(cbuf, 0, readCharNo);
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
