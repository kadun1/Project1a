package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {
	 
	//동적쿼리 처리를 위한 객체
	public PreparedStatement psmt;
	public Statement stmt;
	public Connection con;
	public ResultSet rs;
	
	//기본생성자
	public IConnectImpl() {
		try {
		//드라이버로드
		Class.forName(ORACLE_DRIVER);
		//DB연결
		con = DriverManager.getConnection(ORACLE_URL, "KOSMO", "1234");
		if(con!=null) {
			System.out.println("DB연결성공");
		}
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(String name, String phonenumber, String birthday) {
		try {
			//1.쿼리문준비 : 값의 세팅이 필요한 부분을 ?(인파라미터)로 대체한다.
			String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?, seq_phonebook.nextval)";
			
			//2.prepared객체생성 : 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);
			
			//3.인파라미터 설정
			psmt.setString(1, name);
			psmt.setString(2, phonenumber);
			psmt.setString(3, birthday);
			
			//5.쿼리실행을 위해 prepared객체를 실행한다. 
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(String name) {
		try {	
			//1.쿼리문준비
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			//2.prepared객체생성
			psmt = con.prepareStatement(query);
			//3.사용자로부터 입력받은값을 인파라미터로 설정
			psmt.setString(1, name);
			//4.쿼리실행
			System.out.println(psmt.executeUpdate() 
					+"행이 삭제되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void search(String searchname) {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT name, phonenumber, birthday, seq_num "
					+ " FROM phonebook_tb WHERE name = "+ "'"+searchname+"'";
			 
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");//name컬럼
				String phonenumber = rs.getString("phonenumber");
				String birthday = rs.getString("birthday");
				String seq = rs.getString("seq_num");

				System.out.printf("DB검색결과\n이름 : %s, 전화번호 : %s, 생년월일 : %s, 시퀀스 : %s\n",
						name, phonenumber, birthday, seq);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
	}
	
	//자원해제
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
}
