package com.soccer.web.serviceImpls;

import java.util.List;

import com.soccer.web.daoImpls.PlayerDaoImpl;
import com.soccer.web.daos.PlayerDao;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	
	private static PlayerServiceImpl instance = new PlayerServiceImpl(); 
	// 02 포지션 종류(중복제거,없으면 빈공간)
	
	public static PlayerServiceImpl getInstance(){ 
		return instance;
	}
	private PlayerServiceImpl(){}
	
		@Override
		public List<String> findPositions() {
		return PlayerDaoImpl.getInstance().selectPositions();
	}
	
	@Override
	public List<PlayerBean> findByTeamIdPosition(PlayerBean param) {
		return PlayerDaoImpl.getInstance().selectByTeamIdPositions(param);
	}

	@Override
	public List<PlayerBean> findByTeamIdHeightName(PlayerBean param) {
		return PlayerDaoImpl.getInstance().selectByTeamIdHeightName(param);
	}


}
