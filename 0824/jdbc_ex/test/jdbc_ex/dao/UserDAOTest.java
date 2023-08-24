package jdbc_ex.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import jdbc_ex.domain.UserVo;

//import static org.junit.jupiter.api.Assertions.*;
class UserDAOTest {

	UserDAO dao = UserDAOImpl.getInstance();

//	@Test
	void testInsertUser() {
		UserVo user = new UserVo("test", "1234", "테스트", "USER");
		dao.insertUser(user);

		user = dao.getUser("test");
		assertNotNull(user);
		assertEquals("test", user.getId());
	}

//	@Test
	void testGetUserList() {
		List<UserVo> list = dao.getUserList();
		assertEquals(4, list.size(), "목록의 개수가 일치하지 않음");
//		for (UserVo user : list) {
//			System.out.println(user);
//		}
	}

//	@Test
	void testGetUser() {
		UserVo user = dao.getUser("admin");
		assertNotNull(user);
		assertEquals("admin", user.getId());
	}

//	@Test
	void testUpdateUser() {
		UserVo user = dao.getUser("admin");
		user.setName("최고관리자");

		dao.updateUser(user);
		user = dao.getUser("admin");

		assertNotNull(user);
		assertEquals("최고관리자", user.getName());
	}

	@Test
	void testDeleteUser() {
		dao.deleteUser("test");

		UserVo user = dao.getUser("test");
		assertNull(user);
	}

}
