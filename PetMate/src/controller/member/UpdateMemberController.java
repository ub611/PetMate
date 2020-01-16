package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import model.service.MemberManager;
import model.MemberDTO;

public class UpdateMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateMemberController.class);
//	private MemberDAO memberDAO = new MemberDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
	    String curUserId = UserSessionUtils.getUserFromSession(request.getSession());    //현재 접속한 user_id
//	    String curUserId = "bb";

	    MemberDTO memdto = new MemberDTO();

        MemberManager manager = MemberManager.getInstance();
        memdto = manager.findUser(curUserId);	//현세션ID의 memberDTO객체 
        
        System.out.println(request.getParameter("name"));
        //
        memdto.setName(request.getParameter("name"));			//폼의 parameter들로 정보 새로 설정
        memdto.setPwd(request.getParameter("pwd"));
        memdto.setRegion(request.getParameter("region"));
        
        System.out.println(memdto.getRegion());
        

		manager.update(memdto);	
		
		request.setAttribute("memberDTO", memdto);				                 

		log.debug("Update User : {}", memdto.getRegion());
		
//		if(st == 0)
//			return "redirect:/member/updateMyPage.jsp";		//다시 업데이트 문으로 
//		
		return "/member/myPage/form";
    }
}
