package com.hucloud.di.sample5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.di.sample5.biz.DIPracticeBiz;

/**
 * Main 클래스는 Spring 의 ApplicationContext만 의존관계를 맺는다.
 * ApplicationContext 는 Spring Application 의 모든 객체를 관리하게 된다.
 * applicationContext.xml 에 정의된 클래스들을 Bean 이라 하고, 이것을 저장하는 저장소를
 * Bean Container 라 한다.
 * 
 * Bean Container 에 의해 프로그램의 진행상황이 변경될 수 있다. 또한 클래스들의 생명주기를 Java Application 이 아닌
 * Spring 이 관리한다. 그런 이유로 Inversion of Control. 즉, 제어의 역전(IoC)이라 한다.
 * 
 * Spring DI 를 사용하면, 수정과 확장의 방법이 매우 간편해진다.
 * 추가되어야 할 기능이 있다면, 클래스를 수정할 필요없이, 클래스의 상속을 통해 기능을 추가할 수 있다.
 * 이렇게 기능이 추가된 클래스는 applicationContext.xml 에 정의만 해주면 된다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		DIPracticeBiz diPracticeBiz = ctx.getBean("diPracticeBiz", DIPracticeBiz.class);
		String someString = diPracticeBiz.getSomeString();
		
		System.out.println(someString);
		
	}
	
}
