package com.hucloud.di.sample3;

import com.hucloud.di.sample3.biz.DIPracticeBiz;
import com.hucloud.di.sample3.biz.DIPracticeBizFactory;

/**
 * Main 클래스는 DIPracticeBiz 와의 의존관계를 DIPracticeBizFactory 를 통해 완전히 끊어냈다.
 * 하지만, DIPracticeBiz 는 여전히 DIPracticeDAOImpl 에 의존적이다.
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
