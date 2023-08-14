package java_study.Pratice3.Login;

import javax.swing.JOptionPane;

public class myLogin {

	public static void main(String[] args) {
		Login myLogin = new Login();

		String id = JOptionPane.showInputDialog("아이디를 입력해주세요.");

		int password = Integer.parseInt(JOptionPane.showInputDialog("비밀번호를 입력해주세요."));

		myLogin.checkId(id, password);
		myLogin.checkLogin();
	}

}
