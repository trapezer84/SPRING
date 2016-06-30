package com.hucloud.di.sample9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.di.sample7.biz.DIPracticeBiz;
import com.hucloud.di.sample7.vo.PersonVO;

/**
 * Properties 로 데이터를 주입할 수 있다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextForAnnotationWithBeanDI1_1.xml");
		
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
