package controller.pet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UserSessionUtils;


public class CheckPetFormController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(CheckPetFormController.class);
	 
	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
	    	 //�α��� �ȵǸ� �α��� ȭ������!!
	    	if (!UserSessionUtils.isLogined(request.getSession())) {
	    		request.setAttribute("NotLogin", true);
	    	    request.setAttribute("msg", "�α��� �� �̿����ּ���!");
	    		return "/member/registerSucc/form";
	    	}
            
			return "/member/registerPet.jsp";		// �� ��� ȭ��
	    }
}
