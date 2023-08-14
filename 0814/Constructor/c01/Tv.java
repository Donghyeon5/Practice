package java_study.Pratice3.Constructor.c01;

public class Tv {
	String brand;
	int year;
	int size;

	public Tv() {
	}

	Tv(String brand, int year, int size) {
		this.brand = brand;
		this.year = year;
		this.size = size;
	}

	public void show() {
		System.out.print(brand + "에서만든 ");
		System.out.print(year + "년 ");
		System.out.print(size + "인치 Tv");
	}
}
