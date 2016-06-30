package com.hucloud.di.sample4;

import com.hucloud.di.sample4.biz.DIPracticeBiz;
import com.hucloud.di.sample4.biz.DIPracticeBizFactory;

/**
 * DIPracticeBizImpl 의 구조적 개선을 통해 DIPracticeDAOImpl 과의 의존관계를 끊어냈다.
 * 이로써, Main 클래스는 DIPracticeBizImpl, DIPracticeDAOImpl 과의 의존관계를 완전히 끊어냈다.
 * 
 * 하지만, DIPracticeBizFactory 에서 DIPracticeBizImpl 과 DIPracticeDAOImpl의 의존관계를 만들어냈다.
 * 이것 sample1 의 방법과 동일하게 수정과 확장을 불리하게 만드는 요소가 된다.
 * 
 * 이 의존관계를 완전히 끊어낼 수 있도록 하려면
 * Spring Dependency Injection 을 사용해야 한다.
 * 
 * 클래스의 생성과 소멸을 Spring 이 담당하도록 하는 것이다.
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		DIPracticeBiz diPracticeBiz = DIPracticeBizFactory.getDIPracticeBiz();
		String someString = diPracticeBiz.getSomeString();
		
		System.out.println(someString);
		
	}
	
}
