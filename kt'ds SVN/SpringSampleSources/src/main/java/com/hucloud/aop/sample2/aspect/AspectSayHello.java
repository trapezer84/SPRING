package com.hucloud.aop.sample2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 공통으로 실행될 메소드
 * @author mcjang
 *
 */
public class AspectSayHello {

	public Object hello(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// 어떤 클래스의 어떤 메소드를 실행할 것인지 확인한다.
		String signature = proceedingJoinPoint.getSignature().toShortString();
		System.out.println(signature);
		
		try {
			// 메소드를 실행하기 전에 실행될 공통 메소드
			System.out.println("인사하세요~");
			
			// 메소드를 실행한다.
			Object result = proceedingJoinPoint.proceed();
			return result;
		}
		finally {
			
			// 메소드를 실행한 이후 실행될 공통 메소드
			System.out.println("인사 잘 했습니다~");
		}
		
	}
	
}
