package java_study.Pratice3.Constructor.c02;

public class Book {
	String title;
	String author;

	public Book() {
	}

	Book(String title) {
		this(title, "작자 미상");
	}

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}
