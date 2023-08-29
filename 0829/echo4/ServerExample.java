package java_study.chapter14.echo4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {// 바이트 기반의 통신을 텍스트기반으로 변환,
	// 여러 클라이언트를 상대로 메시지 수신(while 문 활용)
	// 메인메소드 - 클라이언트 접속
	// 작업스레드 - 통신

	public static void main(String[] args) {

		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(10000);) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");

			while (true) {
				Socket socket = serverSocket.accept(); // 접속 대기
				System.out.println("클라이언트 접속 성공");

				// 실제 통신은 작업 스레드로 위임
				Thread t = new WorkThread(socket);
				t.start();

			} // end of while 동시 서버 접속 클라이언트 양식

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
