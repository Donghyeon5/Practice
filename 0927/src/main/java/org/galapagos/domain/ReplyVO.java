package org.galapagos.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class ReplyVO {

	private Long no;
	private Long cno; // Comment의 no
	
	private String writer;
	private String content;
	private Date regDate;
	private Date updateDate;

}
