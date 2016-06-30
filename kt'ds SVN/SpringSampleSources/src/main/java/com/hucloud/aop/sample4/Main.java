package com.hucloud.aop.sample4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.aop.sample2.biz.AOPPracticeBiz;

/**
 * 핵심로직의 실행 이후에 실행됨. 
 * 메소드의 정상 수행 및 예외 발생여부에 관계없이 실행함.
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/applicationContext_Sample4.xml");
		
		AOPPracticeBiz aopPracticeBiz = ctx.getBean("aopPracticeBiz", AOPPracticeBiz.class);
		aopPracticeBiz.sayHello();
		aopPracticeBiz.sayBye();
	}
	
}
