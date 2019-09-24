package com.soccer.web.daoImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pool.Constants;
import com.soccer.web.daos.PlayerDao;

public class PlayerDaoImpl implements PlayerDao{
	
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	public static  PlayerDaoImpl getInstance() {return instance;}
	private static Connection conn ;
	public PlayerDaoImpl() {	}
	
	// 02 포지션 종류(중복제거,없으면 빈공간)
	@Override
	public List<String> selectPositions() {
		List<String> result = new ArrayList<String>(); 
		try {

				System.out.println("연결성공");
				
				String sql = "SELECT DISTINCT (NVL(POSITION,'')) position\r\n" + 
						"FROM PLAYER WHERE POSITION IS NOT NULL";
				ResultSet rs = DatabaseFactory.createDatabase(Constants.VENDOR)
															.getConnection()
															.prepareStatement(sql)
															.executeQuery();
				while (rs.next()) {
					result.add(rs.getString("position"));
				}
				if (conn != null) {	
			}else {
				System.out.println("연결 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	@Override
	public List<PlayerBean> selectByTeamIdPositions(PlayerBean param) {
		
		List<PlayerBean> result = new ArrayList<PlayerBean>(); 

		try {
			if (conn != null) {
				System.out.println("연결성공");

				String sql  = "SELECT PLAYER_NAME , TEAM_ID , POSITION  FROM PLAYER WHERE TEAM_ID LIKE '"+param.getTeamId()+"' AND POSITION LIKE '"+param.getPosition()+"'";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					PlayerBean temp = new PlayerBean();
					temp.setPlayerName(rs.getString(1));
					temp.setTeamId(rs.getString(2));
					temp.setPosition(rs.getString(3));
					
					result.add(temp);
				}
				
			}else {
				System.out.println("연결 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PlayerBean> selectByTeamIdHeightName(PlayerBean param) {
		
		List<PlayerBean> result = new ArrayList<PlayerBean>(); 
		try {
			if (conn != null) {
				System.out.println("연결성공");
				String sql = "SELECT PLAYER_NAME , TEAM_ID , POSITION, HEIGHT FROM PLAYER WHERE TEAM_ID LIKE '"+param.getTeamId()+"' AND HEIGHT >="+param.getHeight()+"  AND PLAYER_NAME LIKE '"+param.getPlayerName()+"%'";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					PlayerBean temp = new PlayerBean();
					temp.setPlayerName(rs.getString(1));
					temp.setTeamId(rs.getString(2));
					temp.setPosition(rs.getString(3));
					temp.setHeight(rs.getString(4));
					result.add(temp);
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
