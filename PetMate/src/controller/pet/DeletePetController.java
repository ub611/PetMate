package controller.pet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.PetManager;

public class DeletePetController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(DeletePetController.class);

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			String deleteId = request.getParameter("userId");
			int pet_id = Integer.parseInt(request.getParameter("petId"));
	    	log.debug("Delete User : {}", deleteId);
	    	
	    	PetManager manager = PetManager.getInstance();
			manager.remove(deleteId, pet_id);			
		
			return "/member/listPet";		// Æê ¸®½ºÆ®
	    }
}
