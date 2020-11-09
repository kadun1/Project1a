package project1.ver09;

public interface IConnect {
	
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	void insert(String name, String phonenumber, String birthday);//입력
	void delete(String name);//삭제
	void search(String searchname);//검색
	void close();//자원반납
}
