package org.galapagos.vo;

public class Member {
	private String name;
	private String userid;
	// name, userId 속성 -> getter,setter로 접근 가능한 정보 property
	// property의 이름은 메서드의 이름을 통해 결정 EX) getName, setName
	public Member() {}
	
	public Member(String name, String userid) {
		super();
		this.name = name;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
