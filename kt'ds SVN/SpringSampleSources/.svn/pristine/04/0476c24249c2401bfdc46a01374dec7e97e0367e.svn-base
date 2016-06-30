package com.hucloud.di.sample1;

import com.hucloud.di.sample1.biz.DIPracticeBiz;

/**
 * 가장 잘못된 형태의 프로그래밍 방법.
 * 
 * 1. Main 클래스는 DIPracticeBiz 라는 클래스에 의존적이다.
 * 2. DIPracticeBiz 는 인터페이스가 아니라 클래스다. 즉, 다형성을 포기한 형태이다. 이런 방법은 수정 및 확장에 매우 불리한 구조이다.
 * 3. DIPracticeBiz 는 다시 DIPractiveDAO 에 의존적이다.
 * 4. DIPracticeBiz 와 마찬가지로 DIPracticeDAO 는 수정 및 확장에 매우 불리한 구조이다. 
 * 
 * 위 문제점을 해결할 수 있는 가장 가까운 방법은 
 * 1. DIPracticeBiz 와 DIPracticeDAO 를 인터페이스로 분리해야한다.
 * 
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		DIPracticeBiz diPracticeBiz = new DIPracticeBiz();
		String someString = diPracticeBiz.getSomeString();
		System.out.println(someString);
		
	}
	
}
