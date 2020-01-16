package controller.pet;

import controller.Controller;
import model.PetDTO;
import model.service.PetManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdatePetController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdatePetController.class);
	
	  @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
	
	    	PetDTO updatePet = new PetDTO(
	    			request.getParameter("userId"),
	    			Integer.parseInt(request.getParameter("petId")),
	    			request.getParameter("kind"),
	    			request.getParameter("pet_age"),
	    			request.getParameter("pet_gender"),
	    			request.getParameter("pet_name"));    
	    	
	    	PetManager manager = PetManager.getInstance();
			manager.update(updatePet);	
		
	    	log.debug("Update User : {}", updatePet);
		
	        return "/member/listPet";		//리스트 보여주기	
	    }
}
