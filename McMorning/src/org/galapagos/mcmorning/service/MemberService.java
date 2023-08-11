package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.cli.Input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UseridCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberService {
	MemberDao dao = new MemberDao();

	public void signUp() {
		// Member 정보 입력
		// id 중복 체크
		// Member 인스턴스 생성
		// 리스트에 넣기(Dao)

		Member member;
		try {
			member = inputMember();
			dao.add(member);
		} catch (UseridCountOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public Member inputMember() throws UseridCountOverException {
		String userid = inputUserid();
		if (userid == null) {
			return null;
		}
		String password = Input.read("비밀번호 : ");
		String name = Input.read("이름 : ");
		String email = Input.read("email : ");

//		Scanner sc = new Scanner(System.in);
//		System.out.print("사용자 ID : ");
//		String userid = sc.nextLine();
//
//		System.out.print("비밀번호 : ");
//		String password = sc.nextLine();
//
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//
//		System.out.print("email : ");
//		String email = sc.nextLine();

		Member member = new Member(userid, password, name, email);
		return member;
	}

	public String inputUserid() throws UseridCountOverException {
		String userid = "";

		for (int i = 0; i < 3; i++) { // 3번
			userid = Input.read("사용자 ID : ");
			Member m = dao.findByUserid(userid);

			if (m != null) { // 중복이면 m=null 이면 중복아님
				System.out.println(userid + " (은)는중복된 아이디입니다.");

			} else {
				return userid;
			}
		}
		throw new UseridCountOverException();
	}
}
