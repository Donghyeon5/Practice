package java_study.chapter11.sec07_set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30)); // 해시코드를 재정의 했기때문에

		System.out.println("총 객체수 : " + set.size()); // 1로 나온다.

	}

}
