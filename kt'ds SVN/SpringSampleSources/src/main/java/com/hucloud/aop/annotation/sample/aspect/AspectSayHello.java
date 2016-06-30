package com.hucloud.aop.annotation.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 공통으로 실행될 메소드
 * @author mcjang
 *
 */
@Aspect
public class AspectSayHello {

	@Pointcut("execution(public * com.hucloud.aop.sample5..*.*(..))")
	public void targetMethod() {
		System.out.println("Aspect 설정됨.");
	}
	
	@Before("targetMethod()")
    public void beforeTargetMethod(JoinPoint thisJoinPoint) {
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        System.out.println("@Before : " + className + "." + methodName + " executed.");
    }
	
    @AfterReturning(pointcut = "targetMethod()", returning = "retVal")
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        System.out.println("@AfterReturning : " + className + "." + methodName + " executed.");
        System.out.println("@AfterReturning : return value is [" + retVal + "]");
 
    }
    
    @AfterThrowing(pointcut = "targetMethod()", throwing = "exception")
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint,
            Exception exception) throws Exception {
    	String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        System.out.println("@AfterThrowing : " + className + "." + methodName + " executed.");
        System.out.println("@AfterThrowing : 에러가 발생했습니다." + exception.getMessage());
 
        throw exception;
    }
    
    @After("targetMethod()")
    public void afterTargetMethod(JoinPoint thisJoinPoint) {
    	String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        System.out.println("@After : " + className + "." + methodName + " executed.");
    }
    
    @Around("targetMethod()")
    public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    	
    	String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = thisJoinPoint.getSignature().getName();
        System.out.println("@Around : " + className + "." + methodName + " executed.");
        
        System.out.println("@Around : 메소드 실행 이전");
        Object retVal = thisJoinPoint.proceed();
 
        System.out.println("@Around : 메소드 실행 이후");
        retVal = retVal + "(modified)";
 
        return retVal;
    }

}
