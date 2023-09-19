package org.galapagos.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	// user 1명당 가져야 할 정보
	private String username;
	private String password;
	private String email;
	private Date regDate;
	private Date updateDate;
	
	private List<AuthVO> authList;
	

}
