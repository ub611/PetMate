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
	    
//		//�α��� ����Ȯ��
//		if (!UserSessionUtils.isLogined(request.getSession())) {
//            return "redirect:/member/login";
//        }
		
		PetManager manager = PetManager.getInstance();

		List<PetDTO> petList = manager.findMyPetList(curUserId);
		
		request.setAttribute("petList", petList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		

		//����Ʈȭ��
		return "/member/listPet.jsp";      
	}
}