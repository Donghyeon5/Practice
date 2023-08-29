package java_study.chapter14.echo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClintExample { // 바이트 기반의 통신을 텍스트기반으로 변환

	public static void main(String[] args) { // 소켓 만들기 성공 -> 서버 연결 성공
		try (Socket socket = new Socket("127.0.0.1", 10000)) {
			System.out.println("서버 연결 성공");
			// 수신용 reader 만들기
			BufferedReader r = new BufferedReader( // buffered 보조스트림 활용 -> 개행문자 활용하기위해 .nextLine 메서드 활용
					new InputStreamReader(socket.getInputStream()));
			// 전송용 writer 만들기
			PrintWriter w = new PrintWriter(socket.getOutputStream());

			Scanner s = new Scanner(System.in);
			System.out.println("문자열 입력 > ");
			String line = s.nextLine(); // 전송할 문자열 입력

			// 메시지 전송
			w.println(line); // line + \n
			w.flush();

			// 메시지 수신
			String receiveLine = r.readLine(); // \n까지 붙어서 리턴
			System.out.println("수신 메시지 : " + receiveLine);
			System.out.println("통신 종료");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
