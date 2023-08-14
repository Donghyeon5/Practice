package java_study.Pratice3.Constructor.c03;

public class Book {
	String title;
	String author;

	Book() {
	}

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void show() {
		System.out.println("책 이름: " + title + " / 저자 :" + author);

	}

}
