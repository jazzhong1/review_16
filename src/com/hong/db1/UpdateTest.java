package com.hong.db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.0.12:1521:xe";	
		String dirver="oracle.jdbc.driver.OracleDriver";
		
		try {
			//1.드라이버 객체생성
			Class.forName(dirver);
			
			//2.Connection 객체 생성 연결
			Connection con=DriverManager.getConnection(url,user,password);
			
			//3.Statment 객체생성
			Statement st=con.createStatement();
			
			//4.sql문 작성
			String sql="update dept set dname='RD',loc='paris' where deptno=50";
			
			//5.쿼리문날리기
			int result=st.executeUpdate(sql);
			
			if(result>0){
				System.out.println(result+"개 테이블 업데이트");
			}
			else{
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
