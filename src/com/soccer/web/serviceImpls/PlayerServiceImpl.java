package com.soccer.web.serviceImpls;

import java.util.List;

import com.soccer.web.daoImpls.PlayerDaoImpl;
import com.soccer.web.daos.PlayerDao;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	PlayerDao dao;
	
	
	public PlayerServiceImpl() {
		dao = new PlayerDaoImpl();
	}
	
	// 02 포지션 종류(중복제거,없으면 빈공간)
	@Override
	public List<String> findPositions() {
		List<String> result = dao.selectPositions();
		return result;
	}

}
