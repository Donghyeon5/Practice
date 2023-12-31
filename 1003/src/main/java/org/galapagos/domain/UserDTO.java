package org.galapagos.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String userid;
	private String password;
	private String password2;
	private String email;
	private String[] hobbies;
//	private List<String>[] hobbies;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
// 문자열을 데이트 타입으로 변환해야함 @DateTimeFormat(pattern="yyyy-MM-dd")사용	
	

}
