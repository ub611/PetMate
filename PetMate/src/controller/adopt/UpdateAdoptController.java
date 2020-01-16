package controller.adopt;

import controller.Controller;
import model.AdoptDTO;
import model.service.AdoptManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateAdoptController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateAdoptController.class);
	
	  @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		  System.out.println("upController: " + Integer.parseInt(request.getParameter("adoptId")));
		  
	    	AdoptDTO updateAdopt = new AdoptDTO(
	    		request.getParameter("userId"),
	    		Integer.parseInt(request.getParameter("adoptId")),
	    		Integer.parseInt(request.getParameter("price")),
	    		Integer.parseInt(request.getParameter("pet_age")),
	    		request.getParameter("kind"),
	    		request.getParameter("pet_gender"),
	    		Integer.parseInt(request.getParameter("isAdopted")),
	    		request.getParameter("date"));    
	    	
	    	AdoptManager manager = AdoptManager.getInstance();
			manager.update(updateAdopt);	
			request.setAttribute("kind", request.getParameter("kind"));
			
	    	log.debug("Update User : {}", updateAdopt);
		
	        return "/adopt/listAdopt";		//리스트 보여주기	
	    }
}
