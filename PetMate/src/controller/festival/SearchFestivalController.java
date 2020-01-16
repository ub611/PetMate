package controller.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.FestivalDTO;
import model.MemberDTO;
import model.dao.FestivalDAO;
import model.dao.MemberDAO;
import model.service.FestivalManager;
import model.service.MemberAnalysis;

public class SearchFestivalController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberDAO memberDAO = new MemberDAO();
		String region = request.getParameter("region");
		String userID = UserSessionUtils.getUserFromSession(request.getSession());
		
		FestivalManager manager = FestivalManager.getInstance();
		MemberAnalysis business = new MemberAnalysis(memberDAO);

		List<FestivalDTO> festivalList = manager.findFestivalList(region);
		List<MemberDTO> memberList = business.recommendFriends(userID);
		
		request.setAttribute("festivalList", festivalList);		
		request.setAttribute("memberList", memberList);
		
//		return "/festival/searchFestival_list.jsp"; 
		return "/festival/list/form";
	}

}
