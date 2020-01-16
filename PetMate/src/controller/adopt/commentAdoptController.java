package controller.adopt;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.AdoptCommentDTO;
import model.AdoptDTO;
import model.SellCommentDTO;
import model.dao.AdoptDAO;

public class commentAdoptController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    String today = sdf.format(cal.getTime());
	  
	    AdoptDAO dao = new AdoptDAO();

	    AdoptCommentDTO adopt = new AdoptCommentDTO(
	            curUserId,
	            1,
	            today,
	            request.getParameter("comment"),
	            request.getParameter("adoptId"));
	       
	    dao.commentCreate(adopt);

		return "/comment/adoptlist";
	}

}
