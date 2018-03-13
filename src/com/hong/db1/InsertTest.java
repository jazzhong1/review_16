package com.hong.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.0.12:1521:xe";		
		String driver="oracle.jdbc.driver.OracleDriver";
		
		try {
			//1 드라이버 객체생성
			Class.forName(driver);
			
			//2. connection 객체생성,연결
			Connection con=DriverManager.getConnection(url, user, password);
			
			//3. Statement 객체생성
			Statement st=con.createStatement();
			
			//4.SQL문 작성
			String sql="insert into dept (deptno,dname,loc) values(60,'PRODUCT','HONGKONG')";
			
			//5.쿼리문날리기
			int result=st.executeUpdate(sql);
			
			if(result>0){
				System.out.println(result+"개 테이블 삽입 ");
			}
			else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
