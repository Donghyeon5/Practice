package java_study.Pratice3.Login;

import javax.swing.JOptionPane;

public class Login {
	String[] id = { "a1", "a2", "a3", "a4" };// 인배이 뉴인수
	int[] password = { 1111, 2222, 3333, 4444 };
	int checkId = 0;
	int checkPassword = 0;

	public void checkId(String id, int password) {
		for (int i = 0; i < this.id.length; i++) {
			if (id.equals(this.id[i])) { // 아이디와 아이디와 같은 배열 확인
				checkId = 1;
				checkPassword2(i, password); // checkPassword 메서드 시행
			}
		}

	}

	public void checkPassword2(int index, int password) {
		if (password == this.password[index]) {
			checkPassword = 1;
		}
	}

	public void checkLogin() {
		if (checkId == 1 && checkPassword == 1) {
			JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
		} else if (checkId == 1 && checkPassword == 0) {
			JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.(비밀번호 오류)");

		} else if (checkId == 1 && checkPassword == 1) {
			JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.(아이디 오류)");
		} else {
			JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
		}

	}
}
