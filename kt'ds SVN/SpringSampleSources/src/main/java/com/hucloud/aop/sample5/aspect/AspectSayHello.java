package com.hucloud.aop.sample5.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * 공통으로 실행될 메소드
 * @author mcjang
 *
 */
public class AspectSayHello {

	public void hello(JoinPoint joinPoint, Object returnValue) throws Throwable {
		
		String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        
        // 공통기능
        System.out.println(className + "." + methodName + " executed.");
		System.out.println("리턴 값 : " + returnValue);
	}
	
}
