package controller.adopt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.service.AdoptManager;

public class DeleteAdoptController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(DeleteAdoptController.class);

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			String deleteId = request.getParameter("userId");
			int adopt_id = Integer.parseInt(request.getParameter("adoptId"));
	    	log.debug("Delete User : {}", deleteId);

			AdoptManager manager = AdoptManager.getInstance();
			manager.remove(deleteId, adopt_id);			
		
			return "/member/registerAdopt/form";		//입양페이지 메인으로
	    }
}
