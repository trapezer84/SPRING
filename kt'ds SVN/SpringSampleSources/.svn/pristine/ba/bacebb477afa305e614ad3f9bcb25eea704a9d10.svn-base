package com.hucloud.di.sample6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.di.sample6.biz.DIPracticeBiz;

/**
 * Annotation 을 통해 xml의 정의가 없어도 bean 을 사용할 수 있다.
 * Bean 으로 등록되어야 하는 클래스들에 @Component 애노테이션을 정의해주고
 * 내부에서 참조하고 있는 클래스가 있다면, 그 클래스에 @Autowired 애노테이션을 정의해준다.
 * 물론, @Autowired 가 정의될 클래스에는 @Component 애노테이션이 정의되어 있어야 한다.
 * 
 * Annotation 이 개발에 편리함을 더해줄 수는 있지만, 유지보수측면에서는 추적의 불편함 때문에 그리 효율적이지 못하다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextForAnnotation.xml");
		
		DIPracticeBiz diPracticeBiz = ctx.getBean("diPracticeBiz", DIPracticeBiz.class);
		String someString = diPracticeBiz.getSomeString();
		
		System.out.println(someString);
		
	}
	
}
