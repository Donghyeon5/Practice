package jdbc_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc_ex.common.jdbcUtil;

//이클립스 컴파일 제대로 안될떄 project - clean
public class InsertUserTest {

	public static void main(String[] args) {
		// sql문에 값을 넣을 때 파라미터화 해서 처리
		String sql = "insert into users(id, password, name, role) " + "values(?, ?, ?, ?)";
		// connection 객체를 통해 생성
		try (Connection conn = jdbcUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 추가하고자 하는 내용 넣기 (실행번호, 값)
			pstmt.setString(1, "ssamz2");
			pstmt.setString(2, "ssamz123");
			pstmt.setString(3, "쌤즈");
			pstmt.setString(4, "ADMIN");
			// insert, update, delete 문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "건 데이터 처리 성공 !");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
