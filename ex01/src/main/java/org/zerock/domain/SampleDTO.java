package org.zerock.domain;

import lombok.Data;


@Data  //@Data를 이용하게 되면, getter/setter/equals()/toString()등의 메서드를 자동 생성해준다.
public class SampleDTO {
	private String name;
	private int age;
}
