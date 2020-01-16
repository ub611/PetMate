package controller.pet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.PetDTO;
import model.service.PetManager;

public class UpdatePetFormController implements Controller{
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		int pet_id = Integer.parseInt(request.getParameter("petId"));
		
		PetManager manager = PetManager.getInstance();
		PetDTO pet = manager.findPet(userId, pet_id);  
	    try{
	         pet = manager.findPet(userId, pet_id);  
	         request.setAttribute("pet", pet);   
	    }catch(Exception e){
	    	return "/member/listPet";   
	    }
	             
       return "/member/updatePet.jsp";   
     }
}
