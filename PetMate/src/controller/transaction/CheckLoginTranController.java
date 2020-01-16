package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UserSessionUtils;


public class CheckLoginTranController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(CheckLoginTranController.class);
	 
	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {	    	 
	    	if(UserSessionUtils.isLogined(request.getSession())){
	    		return "/transaction/registerTransaction/form";		// �۾��� ȭ��
	    	}else{
	    		request.setAttribute("NotLogin", true);
	    		request.setAttribute("exception", "�۾��� ������ �����ϴ�.");
	    		return "/member/registerSell/form";	
	    	}
	    	
	    }
}
