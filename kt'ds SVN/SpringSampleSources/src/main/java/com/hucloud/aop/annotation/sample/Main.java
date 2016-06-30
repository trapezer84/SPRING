package com.hucloud.aop.annotation.sample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hucloud.aop.sample5.biz.AOPPracticeBiz;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/annotation/applicationContext.xml");
		
		AOPPracticeBiz aopPracticeBiz = ctx.getBean("aopPracticeBiz", AOPPracticeBiz.class);
		String hello = aopPracticeBiz.sayHello();
		System.out.println(hello);
	}
	
}
