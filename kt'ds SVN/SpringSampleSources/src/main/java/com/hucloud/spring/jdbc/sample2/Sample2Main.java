package com.hucloud.spring.jdbc.sample2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample2Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/jdbc/rootContext.xml",
				"/jdbc/transactionContext.xml");
		
		Sample2DAO sample2dao = ctx.getBean("sample2DAO", Sample2DAO.class);
		
		sample2dao.showAllNote();
		
		sample2dao.showOneNoteByNumber(13);
		
		NoteVO insertNote = new NoteVO();
		insertNote.setNoteSubject("새로 추가됨");
		insertNote.setNoteContent("내용...내용...");
		sample2dao.insertOneNote(insertNote);
		
		NoteVO updateNote = new NoteVO();
		updateNote.setNoteNumber(13);
		updateNote.setNoteSubject("수정됨...제목");
		updateNote.setNoteContent("수정됨...내용");
		sample2dao.updateOneNoteByNumber(updateNote);
		
		sample2dao.deleteOneNoteByNumber(13);
		
	}
	
}
