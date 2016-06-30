package com.hucloud.di.sample7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.di.sample7.biz.DIPracticeBiz;
import com.hucloud.di.sample7.vo.PersonVO;

/**
 * Component-Scan 과 Bean 의 설정을 복합적으로 사용할 수도 있다.
 * 많이 쓰이는 방법 중 하나다.
 * 
 * 추적하기 쉬운것은 모두 @Autowired 로 사용하고, 
 * 그렇지 않은것은 Bean 을 수동으로 설정한다.
 * 
 * 수동으로 설정한 Bean 도 @Autowired 로 사용할 수 있다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextForAnnotationWithBeanDI1.xml");
		
		DIPracticeBiz diPracticeBiz = ctx.getBean("diPracticeBiz", DIPracticeBiz.class);
		String someString = diPracticeBiz.getSomeString();
		System.out.println(someString);
		
		PersonVO personVO = ctx.getBean("personVO", PersonVO.class);
		System.out.println(personVO.getName());
		System.out.println(personVO.getAge());
		System.out.println(personVO.getUsableLanguage().size());
		for ( String language : personVO.getUsableLanguage() ) {
			System.out.println(language);
		}
		
	}
	
}
