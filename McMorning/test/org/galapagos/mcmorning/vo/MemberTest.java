package org.galapagos.mcmorning.vo;

public class MemberTest {

	public static void main(String[] args) {
		// 단위 테스트 //
		Member m1 = new Member(); // 디폴트 생성자가 잘 있는가
		System.out.println(m1); // toString 이 잘 되있는가

		Member m2 = new Member("kim", "1111", "김동현", "kim@naver.com");
		System.out.println(m2);
		System.out.println(m2.getUserid());
		System.out.println(m2.getName());
		System.out.println(m2.getPassword());
		System.out.println(m2.getEmail());

	}

}
