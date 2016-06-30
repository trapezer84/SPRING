package com.hucloud.aop.sample2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.aop.sample2.biz.AOPPracticeBiz;

/**
 * 핵심로직의 전/후/에러발생 시 동작하는 Aspect 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/applicationContext.xml");
		
		AOPPracticeBiz aopPracticeBiz = ctx.getBean("aopPracticeBiz", AOPPracticeBiz.class);
		aopPracticeBiz.sayHello();
	}
	
}
