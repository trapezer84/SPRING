package com.hucloud.di.sample3.biz;

public class DIPracticeBizFactory {

	public static DIPracticeBiz getDIPracticeBiz() {
		return new DIPracticeBizImpl();
	}
	
}
