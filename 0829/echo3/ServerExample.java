package java_study.chapter14.echo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {// 바이트 기반의 통신을 텍스트기반으로 변환, 여러 클라이언트를 상대로 메시지 수신(while 문 활용)

	public static void main(String[] args) {
		Socket socket = null;
		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(10000);) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");

			while (true) {
				socket = serverSocket.accept(); // 접속 대기
				System.out.println("클라이언트 접속 성공");

				// 수신용 reader 만들기
				BufferedReader r = new BufferedReader( // buffered 보조
						new InputStreamReader(socket.getInputStream()));
				// 전송용 writer 만들기
				PrintWriter w = new PrintWriter(socket.getOutputStream());

				// 메시지 수신
				String line = r.readLine(); // \n까지 붙어서 리턴
				System.out.println("서버 수신 메시지 : " + line);

				// 메시지 전송
				w.println(line); // line + \n
				w.flush();
				socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
