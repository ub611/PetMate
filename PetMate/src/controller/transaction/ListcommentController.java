package controller.transaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.SellCommentDTO;
import model.dao.CommentDAO;

public class ListcommentController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CommentDAO dao = new CommentDAO();
		List<SellCommentDTO> comList = dao.findComList(request.getParameter("sellId"));
		
		request.setAttribute("comList", comList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));	
		
		return "/transaction/view";
	}

}
