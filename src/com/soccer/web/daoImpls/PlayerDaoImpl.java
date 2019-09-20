package com.soccer.web.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.daos.PlayerDao;

public class PlayerDaoImpl implements PlayerDao{
	// 02 포지션 종류(중복제거,없으면 빈공간)
	@Override
	public List<String> selectPositions() {
		
		List<String> result = new ArrayList<String>(); 
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe", 
				userName="c##bit", passWord="bitcamp";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userName, passWord);
			if (conn != null) {
				System.out.println("연결성공");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT (NVL(POSITION,'')) position\r\n" + 
						"FROM PLAYER WHERE POSITION IS NOT NULL");
				while (rs.next()) {
					result.add(rs.getString("position"));
				}

				
			}else {
				System.out.println("연결 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
