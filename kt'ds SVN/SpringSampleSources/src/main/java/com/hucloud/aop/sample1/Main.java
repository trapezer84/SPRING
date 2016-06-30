package com.hucloud.aop.sample1;

import com.hucloud.aop.sample1.biz.AOPPracticeBiz;
import com.hucloud.aop.sample1.biz.AOPPracticeBizImpl;

/**
 * Spring 은 Aspect Oriented Programming 을 지원한다.
 * 관점 지향 프로그래밍 이라 하는 여기서 관점은 "어떤 기능이 실행되기 이전, 이후, 예외 발생 시" 등으로 볼 수 있다.
 * 
 * AOP 를 사용하지 않으면 아래 예제와 같이 모두 작성을 해주어야만 한다.
 * 
 * 특정 시점에 실행한다 라는 것은 사실, 인터셉터와 유사한데, 차이점이 존재한다.
 * Interceptor 는 Dispatcher Sevlet 과 Controller 사이에서 동작한다.
 * 하지만 AOP 는 개발자가 지정한 지점에서 동작한다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		AOPPracticeBiz aopPracticeBiz = new AOPPracticeBizImpl();
		
		// 핵심기능 전/후에 공통기능을 실행하기 위해서 아래와 같이 실행한다.
		System.out.println("인사하세요~");
		aopPracticeBiz.sayHello();
		System.out.println("인사 잘 했습니다~");
		
	}
	
}
