package controller.adopt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.AdoptCommentDTO;
import model.dao.AdoptDAO;

public class commentListAdoptController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AdoptDAO dao = new AdoptDAO();
		
		List<AdoptCommentDTO> adoptList = dao.findComList(request.getParameter("adoptId"));
		
		request.setAttribute("adoptList", adoptList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		
		
		return "/adopt/viewAdopt";
		
	}

}
