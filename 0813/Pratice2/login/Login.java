package java_study.Pratice2.login;

import javax.swing.JOptionPane;

public class Login {
	// 로그인 -> 아이디 비밀번호 입력 -> 로그인에 성공하였습니다/실패하였습니다.

	String[] id = { "user1", "user2", "user3", "user4" };
	int[] password = { 1111, 2222, 3333, 4444 };
	int checkId = 0;
	int checkPassword = 0;

	public void checkId(String id, int password) { // checkId의 메소드는 변수 id,password 필요

		for (int i = 0; i < this.id.length; i++) {
			if (id.equals(this.id[i])) {
				checkId = 1;
				checkPassword2(i, password);
			}
		}
	}

	public void checkPassword2(int index, int password) {
		// 해당 아이디의 인덱스에 맞는 비밀번호인지 확인
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
