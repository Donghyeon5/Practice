package jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//롬복 사용하여 getter, setter, tostring, 생성자 만들기

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVo {
	// private 멤버 변수 선언
	private String id;
	private String password;
	private String name;
	private String role;

}
