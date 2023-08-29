package java_study.chapter14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAdderssExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP주소 : " + local.getHostAddress());
			// localhost -> 현재 프로그램 실행된느 컴퓨터 주소
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				System.out.println("www.naver.com 의 IP주소 : " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try (ServerSocket server = new ServerSocket(10000)) {
			Socket socket = server.accept(); // 접속 대기, 접속처리

			// 실제 통신
			// 수신 Reader 준비
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 전송 Writer 준비
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			// 메시지 수신
			// 프로토콜
			// 메시지 전송
			w.flush();
			socket.close();
			// 실제 통신 끝
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 클라이언트 프로그램
		try (Socket socket = new Socket("127.0.0.1", 10000)) {
			// socket 생성 성공은 서버와 연결 됐음을 의미
			// 스트림을 통한 통신 수행
		} catch (Exception e) {
			e.printStackTrace(); // 실패시
		}

	}

}
