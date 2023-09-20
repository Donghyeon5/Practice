package org.galapagos.domain;

public class AuthVO {
	private String username;
	private String auth;
	public String getAuth() {
		return null;
	}
	
	// MemberVO : AuthVO = 1:N
	// AuthVO 가 MemberVO 안으로 들어가야함
}
