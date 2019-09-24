package com.soccer.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceImpls.PlayerServiceImpl;
import com.soccer.web.services.PlayerService;

@WebServlet("/player.do")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		String viewPage = "/WEB-INF/views/"+page+".jsp";
		
		PlayerBean pb; 

		switch (action) {
		case "move": 			break;
		case "find02":
			viewPage = "/WEB-INF/views/2_positions.jsp";
			request.setAttribute("positions",PlayerServiceImpl.getInstance().findPositions());
			break;
		case "find04":
			pb = new PlayerBean(); 
			pb.setPosition(request.getParameter("position"));
			pb.setTeamId(request.getParameter("teamId"));
			
			request.setAttribute("player", PlayerServiceImpl.getInstance().findByTeamIdPosition(pb));
			break;
		case "find05":
			pb = new PlayerBean(); 
			pb.setPosition(request.getParameter("position"));
			pb.setTeamId(request.getParameter("teamId"));
			pb.setHeight(request.getParameter("height"));
			pb.setPlayerName(request.getParameter("lastname"));
			
			request.setAttribute("origin", pb);
			request.setAttribute("player", PlayerServiceImpl.getInstance().findByTeamIdHeightName(pb));
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
