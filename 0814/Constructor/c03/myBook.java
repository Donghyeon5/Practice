package java_study.Pratice3.Constructor.c03;

import java.util.Scanner;

public class myBook {

	public static void main(String[] args) {

		Book[] myBook = new Book[3];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < myBook.length; i++) {
			System.out.print(" 책의 이름을 입력하세요.");
			String title = sc.next();
			System.out.print("책의 저자를 입력하세요.");
			String author = sc.next();
			myBook[i] = new Book(title, author);
		}

		for (int i = 0; i < myBook.length; i++) {
			myBook[i].show();
		}

	}

}
