package java_study.Pratice2.student;

import javax.swing.JOptionPane;

public class Student {

	String[] Name = { "홍길동", "임꺽정", "건담", "코난" };
	int[] Score = { 100, 99, 90, 53 };
	int[] Number = { 101, 102, 103, 104 };

	// showinfo(학번) -> 해당 학생의 정보 출력

	public void showinfo(int Number) {
		for (int i = 0; i < this.Number.length; i++) {
			if (Number == this.Number[i]) {
				String info = "이름 :" + Name[i];
				info = info + "/점수 : " + Score[i];
				info = info + "/학번 : " + this.Number[i];
				JOptionPane.showMessageDialog(null, info);
			}
		}
	}

	// showScore => 전교생의 총점과 평균을 구해주는 메서드

	public void showScore() {
		double total = 0.0;
		double avg = 0.0; // 0으로 초기화

		for (int i = 0; i < Name.length; i++) {
			total = total + Score[i];
		}

		avg = total / Name.length;
		String info = "전교생의 총점 : " + total;
		info = info + "/평균 : " + String.format("%2f", avg);
		JOptionPane.showMessageDialog(null, info);
	}
}
