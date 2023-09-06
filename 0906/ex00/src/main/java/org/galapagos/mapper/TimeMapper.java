package org.galapagos.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper { // 구현체를 동적으로 만들어줌
	@Select("SELECT sysdate()")
	public String getTime(); //@을 통해서 sql 배정
	
	public String getTime2(); //TimeMapper.xml을 통해 배정
}
