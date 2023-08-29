package java_study.chapter14.echo1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClintExample {

	public static void main(String[] args) { // 소켓 만들기 성공 -> 서버 연결 성공
		try (Socket socket = new Socket("127.0.0.1", 10000)) {
			System.out.println("서버 연결 성공");

			InputStream in = socket.getInputStream(); // 수신 스트림
			OutputStream out = socket.getOutputStream(); // 전송 스트림

			String str = "Hello, Server"; // String 메세지
			out.write(str.getBytes()); // 바이트 형식으로 변환
			out.flush(); // 버퍼에 있는 것까지, 꼭 해주기
			System.out.println("메시지 전송 : " + str);

			byte arr[] = new byte[100]; // 수신 버퍼 가동
			in.read(arr); // 메시지 수신
			System.out.print("메시지 수신 : ");
			System.out.println(new String(arr)); // String 형식으로 변환

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
