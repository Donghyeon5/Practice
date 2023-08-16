package java_study.chapter11.sec07_set;

import java.util.Objects;

public class Member {

	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 같은 참조인가요
			return true;
		if (obj == null) // null 이면
			return false;
		if (getClass() != obj.getClass()) // 클래스가 다르면
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

//	public boolean equals(Object obj) {
//		if (obj instanceof Member) {
//			Member member = (Member) obj;
//			return member.name.equals(name) && (member.age == age);
//		} else {
//			return false;
//		}
//	}
//
//	public int hashCode() {
//		return name.hashCode() + age; // 해시코드 재정의
//	}
}
