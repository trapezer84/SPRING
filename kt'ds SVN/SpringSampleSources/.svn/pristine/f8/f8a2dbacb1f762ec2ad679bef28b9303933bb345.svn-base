package com.hucloud.di.sample2;

import com.hucloud.di.sample2.biz.DIPracticeBiz;
import com.hucloud.di.sample2.biz.DIPracticeBizImpl;

/**
 * Main 클래스는 DIPracticeBiz 를 인터페이스로 사용하면서 강한 의존관계를 끊었다.
 * 하지만, 여전히 new 키워드를 사용하면서 DIPracticeImpl과의 새로운 의존관계를 맺었다.
 * 클래스의 수정이나 확장면에서 더 나아진 방법이지만, 아주 좋은 방법은 아니다.
 * 
 * 또한, DIPracticeBiz 는 여전히 DIPracticeDAOImpl 에 의존적이다.
 * 
 * 강한 의존관계를 끊어내기 위해서는 new 키워드를 삭제해
 * 클래스간의 호출을 막아야 한다.
 * 
 * 
 * @author mcjang
 *
 */
public class Main {

	public static void main(String[] args) {
		
		DIPracticeBiz diPracticeBiz = new DIPracticeBizImpl();
		String someString = diPracticeBiz.getSomeString();
		
		System.out.println(someString);
		
	}
	
}
