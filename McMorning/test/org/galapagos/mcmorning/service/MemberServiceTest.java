package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.exception.UseridCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {

	public static void main(String[] args) {
		testInputMember();
	}

	static void testInputMember() {
		MemberService service = new MemberService();

		Member m;
		try {
			m = service.inputMember();
			System.out.println(m);
		} catch (UseridCountOverException e) {
			System.out.println(e.getMessage());
		}

	}
}
