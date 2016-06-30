package com.hucloud.spring.jdbc.sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseOJDBC {

	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	private static final String INSERT_QUERY = " INSERT INTO NOTE ( " +
													" NOTE_NUMBER, NOTE_SUBJECT, NOTE_CONTENT)  " +
													" VALUES ( NOTE_NUMBER_SEQ.NEXTVAL, ?, ?) ";
	
	private static final String SELECT_WITHOUT_CONDITION_QUERY = 
			" SELECT NOTE_NUMBER, NOTE_SUBJECT, NOTE_CONTENT FROM NOTE ";
	private static final String SELECT_WITH_CONDITION_QUERY = 
			" SELECT NOTE_NUMBER, NOTE_SUBJECT, NOTE_CONTENT FROM NOTE WHERE NOTE_NUMBER = ?  ";
	
	private void ojdbcInsertTest() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		loadDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"sys as sysdba", "wkdalsckd1");
			pstmt = conn.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, "제목을 입력합니다.");
			pstmt.setString(2, "내용입니다.");
			
			pstmt.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if ( pstmt != null ) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	private void ojdbcSelectWithoutConditionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		loadDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"sys as sysdba", "wkdalsckd1");
			pstmt = conn.prepareStatement(SELECT_WITHOUT_CONDITION_QUERY);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if ( rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if ( pstmt != null ) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	private void ojdbcSelectWithConditionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		loadDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"sys as sysdba", "wkdalsckd1");
			pstmt = conn.prepareStatement(SELECT_WITH_CONDITION_QUERY);
			pstmt.setInt(1, 5);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if ( rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if ( pstmt != null ) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public void loadDriver() {
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {}
	}
	
	public static void main(String[] args) {
		UseOJDBC useOJDBC = new UseOJDBC();
		useOJDBC.ojdbcInsertTest();
		useOJDBC.ojdbcSelectWithoutConditionTest();
		useOJDBC.ojdbcSelectWithConditionTest();
	}
	
}
