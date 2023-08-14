package java_study.Pratice3.Constructor.c02;

public class myBook {

	public static void main(String[] args) {
		Book littlePrince = new Book("어리왕자", "생텍쥐페리");
		Book legendBook = new Book("어느 영웅전기");
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(legendBook.title + " " + legendBook.author);
	}

}
