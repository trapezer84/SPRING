package com.hucloud.aop.sample6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.aop.sample2.biz.AOPPracticeBiz;

/**
 * 핵심로직의 실행 중 예외 발생시에만 실행됨.
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/applicationContext_Sample6.xml");
		
		AOPPracticeBiz aopPracticeBiz = ctx.getBean("aopPracticeBiz", AOPPracticeBiz.class);
		aopPracticeBiz.sayHello();
		aopPracticeBiz.sayBye();
	}
	
}
