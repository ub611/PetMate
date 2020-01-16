package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.MemberDTO;
import model.service.MemberManager;

public class UpdateMemberFormController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);
	   
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String curUserId = UserSessionUtils.getUserFromSession(request.getSession());    //현재 접속한 user_id
//		String curUserId = "bb";
		
		MemberDTO memdto = new MemberDTO();
	
        log.debug("View Mypage Member : {}", memdto);


         MemberManager manager = MemberManager.getInstance();
         memdto = manager.findUser(curUserId);
         
         System.out.println(curUserId);
         
         if(memdto != null) {
        	 request.setAttribute("memberDTO", memdto);				                 
        	 return "/member/updateMyPage.jsp";     
         }
         else
        	 return "/main/form";// 성공 시 회원가입한 내용 보여주는곳으로 redirect작성 필요
         
	    }

}

