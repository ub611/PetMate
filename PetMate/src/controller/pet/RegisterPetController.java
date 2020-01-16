package controller.pet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.PetDTO;
import model.dao.PetDAO;
import model.service.PetManager;

public class RegisterPetController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterPetController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//현재 접속한 유저 아이디
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());		
		
		PetDTO pet = new PetDTO(
				curUserId,
				0,
				request.getParameter("kind_ID"),
				request.getParameter("pet_age"),
				request.getParameter("pet_gender"),
				request.getParameter("pet_name"));
		
		log.debug("Create Pet : {}", pet);
		
		try{
			PetManager manager = PetManager.getInstance();
	        manager.create(pet);
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/main.jsp";
		}
		
		return "/member/listPet"; 	//리스트 보여주기
		
	}
	  
}
