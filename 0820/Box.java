package java_study.chapter12;

public class Box<T> {
	private T t; // t변수에 T 제네릭 사용

	public T get() { // get 메소드
		return t;
	}

	public void set(T t) { // set 생성자 (T
		this.t = t;
	}
}
