package org.galapagos.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //bean 으로 등록, (key-> chef 타입, value -> 인스턴스)
// 인스턴스 생성 -> Spring context에 등록(map)으로 관리 (key:value)
@Data
public class Chef { // chef 인스턴스 
	
}
