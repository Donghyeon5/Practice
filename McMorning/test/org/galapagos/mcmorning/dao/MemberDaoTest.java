package org.galapagos.mcmorning.dao;

import java.util.List;

import org.galapagos.mcmorning.vo.Member;

public class MemberDaoTest {

	public static void main(String[] args) {
//		MemberDao dao = new MemberDao();
//
//		List<Member> list = dao.getMemberList();
//		for (Member m : list) {
//			System.out.println(m);
//		}
//
//		int l = list.size();
//		Member m2 = new Member("dooli", "1234", "둘리", "dooli@naver.com");
//		dao.add(m2);
//
////		if (list.size() != 5) {
////			System.out.println("추가 실패");
////		}
//
//		// 단정문 VM 매개변수로 -ea -> java -em MemberDaoTest
//		assert list.size() == l + 1 : "추가 실패"; // 통과못하면 예외 이유로 둘 것!

		testRead();
		testAdd();
		testFindbyUserid();
		testUpdate();
	}

	static void testRead() {
		MemberDao dao = new MemberDao();

		List<Member> list = dao.getMemberList();
		for (Member m : list) {
			System.out.println(m);
		}

	}

	static void testAdd() {
		MemberDao dao = new MemberDao();
		List<Member> list = dao.getMemberList();

		int l = list.size();
		Member m2 = new Member("dooli", "1234", "둘리", "dooli@naver.com");
		dao.add(m2);

		// 단정문 VM 매개변수로 -ea -> java -ea MemberDaoTest
		assert list.size() == l + 1 : "추가 실패"; // 통과못하면 예외 이유로 둘 것!
	}

	static void testFindbyUserid() {
		MemberDao dao = new MemberDao();

		String userid = "hong";
		Member m = dao.findByUserid(userid);

		assert m != null && userid.equals(m.getUserid()) : userid + "검색 실패";
	}

	static void testUpdate() {
		MemberDao dao = new MemberDao();
		Member m = new Member("kang", "1234", "강길동", "kang@gmial.com");
		Member m2 = dao.update(m);
		assert m2 != null && m == m2 : "업데이트 실패";

		m = dao.findByUserid("hong");
		m.setEmail("hong@gmail.com");
		m2 = dao.update(m);
		assert m2 != null && m == m2 : "업데이트 실패";

	}

	static void testDelete() {
		MemberDao dao = new MemberDao();
		Member m = dao.delete("ko");

		assert m != null && m.getUserid().equals("ko") : "삭제 실패";

	}
}
