package com.hucloud.aop.sample5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.aop.sample5.biz.AOPPracticeBiz;

/**
 * 핵심로직의 정살 실행 이후에 실행됨.
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/applicationContext_Sample5.xml");
		
		AOPPracticeBiz aopPracticeBiz = ctx.getBean("aopPracticeBiz", AOPPracticeBiz.class);
		String hello = aopPracticeBiz.sayHello();
		System.out.println(hello);
	}
	
}
