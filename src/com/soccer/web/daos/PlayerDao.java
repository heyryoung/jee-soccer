package com.soccer.web.daos;

import java.util.List;

import com.soccer.web.domains.PlayerBean;

public interface PlayerDao {
	// 02 포지션 종류(중복제거,없으면 빈공간)
	public List<String> selectPositions();
	public List<PlayerBean> selectByTeamIdPositions(PlayerBean param);
	public List<PlayerBean> selectByTeamIdHeightName(PlayerBean param);
}
