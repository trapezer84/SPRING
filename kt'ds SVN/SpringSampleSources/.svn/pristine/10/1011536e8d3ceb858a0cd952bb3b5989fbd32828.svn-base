package com.hucloud.di.sample8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.di.sample8.biz.DIPracticeBiz;
import com.hucloud.di.sample8.vo.PersonVO;

/**
 * PersonVO 가 생성자 DI 를 사용해 데이터가 주입되었다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextForAnnotationWithBeanDI2_1.xml");
		
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
