package org.galapagos.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


@Component // restaurant 타입과 밸류 등록
@Data
public class Restaurant {
	@Setter(onMethod_ = { @Autowired}) 
	// @Autowired -> setChef를 호출해서 자동으로 주입해달라
	// chef 라는 타입으로 등록된 bean 이 있는지 탐색, 있다면 chef의 밸류를 setChef()에 주입
	private Chef chef; // 의존 객체, 이 타입의 객체를 찾아서 setter로 주입
	
}
