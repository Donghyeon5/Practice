package java_study.chapter10;

import java.io.IOException;

public class NullPointExceptionExample {

	public static void main(String[] args) {
		String data = null;
		System.out.println(data.toString());

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
