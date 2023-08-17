package java_study.chapter13.seco1;

import java.io.Serializable;

public class ClassA implements Serializable {
	int field1;
	ClassB field2 = new ClassB(); // classb를 클래스로 한 객체 field2 생성

	// 직렬화에서 제외
	static int field3;
	transient int field4; // transient -> Serializable에서 제외하고 싶을 때 사용
}
