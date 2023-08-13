package java_study.Pratice2.student;

import javax.swing.JOptionPane;

public class myStudent {

	public static void main(String[] args) {
		Student myStudent = new Student();
		int myNumber = Integer.parseInt(JOptionPane.showInputDialog("학번을 입력해주세요"));
		myStudent.showinfo(myNumber);
		myStudent.showScore();
	}

}
