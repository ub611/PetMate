package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.AdoptDTO;
import model.PetDTO;
import model.service.AdoptManager;
import model.service.PetManager;

public class ListPetController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());	
	    
//		//로그인 여부확인
//		if (!UserSessionUtils.isLogined(request.getSession())) {
//            return "redirect:/member/login";
//        }
		
		PetManager manager = PetManager.getInstance();

		List<PetDTO> petList = manager.findMyPetList(curUserId);
		
		request.setAttribute("petList", petList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		

		//리스트화면
		return "/member/listPet.jsp";      
	}
}