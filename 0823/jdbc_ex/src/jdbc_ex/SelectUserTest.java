package jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc_ex.common.jdbcUtil;

public class SelectUserTest {

	public static void main(String[] args) {

		String sql = "select * from users"; // 시행문 따로 빼놓고
		try (Connection conn = jdbcUtil.getConnection();
				Statement stmt = conn.createStatement(); // sql문 실행 클래스
				ResultSet rs = stmt.executeQuery(sql)) {// sql문 실행 메서드
			while (rs.next()) { // 행의 갯수(실행 횟수)만큼 계속 실행
				System.out.println(rs.getString("name")); // 얻고자하는 콜럼의 이름
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//try (Connection conn = jdbcUtil.getConnection()) {
//	String sql = "select * from users";
//	Statement stmt = conn.createStatement(); // sql문 실행 클래스
//	ResultSet rs = stmt.executeQuery(sql); // sql문 실행 메서드
//	while (rs.next()) { // 행의 갯수(실행 횟수)만큼 계속 실행
//		System.out.println(rs.getString("name")); // 얻고자하는 콜럼의 이름
//	}
//	stmt.close(); // 종료
//	rs.close(); // 종료
//}
//
//catch (Exception e) {
//	e.printStackTrace();
//}