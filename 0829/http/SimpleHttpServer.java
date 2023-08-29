package java_study.chapter14.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	public static void main(String[] args) {

		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(9090);) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");

			while (true) {
				Socket socket = serverSocket.accept(); // 접속 대기
				System.out.println("클라이언트 접속 성공");

				BufferedReader r = new BufferedReader( // buffered 보조
						new InputStreamReader(socket.getInputStream()));

				// 1. 요청 라인
				String line = r.readLine();
				System.out.println(line);
				String[] url = line.split(""); // 공백으로 끊기
				System.out.println("요청한 파일 : " + url[1]);

				// 2. 요청 헤더 (key : value)
				while (true) {
					line = r.readLine();
					if (line.equals("")) { // 헤더의 끝, 비어있는 빈줄이 있는 곳 까지 읽는다.
						break;
					}
					System.out.println(line);
				}
				// 3. BODY - GET 요청일 때는 없음

				// 응답 내보내기
				PrintWriter w = new PrintWriter(socket.getOutputStream());

				// 1. 응답 라인
				w.println("HTTP/1.1 200 OK");

				// 2. 헤더
				w.println("Content-type: text/html"); // body를 내보낼 건데 html로 해석하라
				w.println(); // 헤더의 끝 (비어있는 줄)

				// 3. body 부분
				w.println("<html>");
				w.println("<body><h1>Hello</h1></body>");
				w.println("</html>");
				w.flush();
				socket.close();

			} // end of while 동시 서버 접속 클라이언트 양식

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
