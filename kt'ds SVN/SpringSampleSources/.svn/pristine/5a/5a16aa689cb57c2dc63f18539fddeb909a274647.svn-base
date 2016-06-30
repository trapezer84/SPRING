package com.hucloud.spring.jdbc.sample2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Sample2DAOImpl implements Sample2DAO {

	private final int SELECT_ALL = 0;
	private final int SELECT_ONE_BY_NUMBER = 1;
	private final int INSERT_NOTE = 2;
	private final int UPDATE_NOTE = 3;
	private final int DELETE_NOTE = 4;
	private final int GET_MODIFIED_NUMBER = 5;
	
	private JdbcTemplate jdbcTemplate;
	private List<String> queries;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setQueries(List<String> queries) {
		this.queries = queries;
	}

	@Override
	public void showAllNote() {
		
		List<NoteVO> notes = jdbcTemplate.query(queries.get(SELECT_ALL), new RowMapper<NoteVO>() {
			@Override
			public NoteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoteVO note = new NoteVO();
				note.setNoteNumber(rs.getInt(1));
				note.setNoteSubject(rs.getString(2));
				note.setNoteContent(rs.getString(3));
				return note;
			}
		});
		System.out.println(notes.size());
		for ( NoteVO note : notes ) {
			System.out.println(note.getNoteNumber());
			System.out.println(note.getNoteSubject());
			System.out.println(note.getNoteContent());
		}
	}

	@Override
	public void showOneNoteByNumber(int number) {
		NoteVO note = null;
		
		try {
			note = jdbcTemplate.queryForObject(queries.get(SELECT_ONE_BY_NUMBER), new Object[]{number}, 
					new RowMapper<NoteVO>() {
				@Override
				public NoteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					NoteVO note = new NoteVO();
					note.setNoteNumber(rs.getInt(1));
					note.setNoteSubject(rs.getString(2));
					note.setNoteContent(rs.getString(3));
					return note;
				}
			});
		}
		catch(EmptyResultDataAccessException erdae) {
			System.out.println("Empty Data...");
			note = new NoteVO();
		}
		
		System.out.println(note.getNoteNumber());
		System.out.println(note.getNoteSubject());
		System.out.println(note.getNoteContent());
	}

	@Override
	public void insertOneNote(NoteVO noteVO) {
		jdbcTemplate.update(queries.get(INSERT_NOTE), noteVO.getNoteSubject(), noteVO.getNoteContent());
		int addedNoteNumber = jdbcTemplate.queryForObject(queries.get(GET_MODIFIED_NUMBER), Integer.class);
		
		// Transaction Test를 위한 부분
//		Integer.parseInt("s");
		
		showOneNoteByNumber(addedNoteNumber);
	}

	@Override
	public void updateOneNoteByNumber(NoteVO noteVO) {
		jdbcTemplate.update(queries.get(UPDATE_NOTE), noteVO.getNoteSubject(), noteVO.getNoteContent(), 
				noteVO.getNoteNumber());
		showOneNoteByNumber(noteVO.getNoteNumber());
	}

	@Override
	public void deleteOneNoteByNumber(int number) {
		jdbcTemplate.update(queries.get(DELETE_NOTE), number);
		showOneNoteByNumber(number);
	}
	
}

