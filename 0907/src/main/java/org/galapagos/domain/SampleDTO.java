package org.galapagos.domain;

import lombok.Data;

@Data
public class SampleDTO {
	// ?name=홍길동&age=20 이라는 정보를 얻기 위함
	private String name;
	private int age;
}
