package com.soccer.web.services;

import java.util.List;

public interface PlayerService {
	
	// 02 포지션 종류(중복제거,없으면 빈공간)
	public List<String> findPositions();
	

}
