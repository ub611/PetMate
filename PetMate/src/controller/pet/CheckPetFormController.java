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
	    	 //로그인 안되면 로그인 화면으로!!
	    	if (!UserSessionUtils.isLogined(request.getSession())) {
	    		request.setAttribute("NotLogin", true);
	    	    request.setAttribute("msg", "로그인 후 이용해주세요!");
	    		return "/member/registerSucc/form";
	    	}
            
			return "/member/registerPet.jsp";		// 펫 등록 화면
	    }
}
