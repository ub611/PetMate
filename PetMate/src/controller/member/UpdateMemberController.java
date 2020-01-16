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
	    String curUserId = UserSessionUtils.getUserFromSession(request.getSession());    //���� ������ user_id
//	    String curUserId = "bb";

	    MemberDTO memdto = new MemberDTO();

        MemberManager manager = MemberManager.getInstance();
        memdto = manager.findUser(curUserId);	//������ID�� memberDTO��ü 
        
        System.out.println(request.getParameter("name"));
        //
        memdto.setName(request.getParameter("name"));			//���� parameter��� ���� ���� ����
        memdto.setPwd(request.getParameter("pwd"));
        memdto.setRegion(request.getParameter("region"));
        
        System.out.println(memdto.getRegion());
        

		manager.update(memdto);	
		
		request.setAttribute("memberDTO", memdto);				                 

		log.debug("Update User : {}", memdto.getRegion());
		
//		if(st == 0)
//			return "redirect:/member/updateMyPage.jsp";		//�ٽ� ������Ʈ ������ 
//		
		return "/member/myPage/form";
    }
}
