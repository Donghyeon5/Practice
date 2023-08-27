package jdbc_ex.dao;

import java.util.List;

import jdbc_ex.domain.UserVo;

public interface UserDAO {

	// 회원 등록 메서드
	void insertUser(UserVo user);

	// 회원 목록 조회 메서드
	List<UserVo> getUserList();

	// 회원 정보 조회
	UserVo getUser(String id);

	// 회원 수정
	void updateUser(UserVo user);

	// USERS 테이블 관련 CRUD 메소드
	// 회원 삭제
	void deleteUser(String id);

}