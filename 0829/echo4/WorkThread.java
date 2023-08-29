package java_study.chapter14.echo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkThread extends Thread {

	Socket socket; // 멤버 변수 socket

	public WorkThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// 스레드의 작업 정의
		try {

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
