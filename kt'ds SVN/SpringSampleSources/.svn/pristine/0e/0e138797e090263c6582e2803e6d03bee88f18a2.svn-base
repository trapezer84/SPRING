package com.hucloud.aop.sample3.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * 공통으로 실행될 메소드
 * @author mcjang
 *
 */
public class AspectSayHello {

	public void hello(JoinPoint joinPoint) throws Throwable {
		
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        // 공통기능
        System.out.println(className + "." + methodName + " executed.");
        System.out.println("인사합니다~");
		
	}
	
}
