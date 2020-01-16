package controller.adopt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.AdoptDTO;
import model.service.AdoptManager;

public class ListAdoptController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String kind = (String)request.getParameter("kind");
    	
    	if(kind == null){	//입양 등록 후 리스트 출력할 때 
    		kind = (String)request.getAttribute("kind");
    		if(kind == null){
    			kind = request.getParameter("kind");
    		}
    	}
    	System.out.println("kind: " + kind);
    	
		
		AdoptManager manager = AdoptManager.getInstance();

		List<AdoptDTO> adoptList = manager.findAdoptList(kind);
		
		request.setAttribute("adoptList", adoptList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		

		//리스트화면
		return "/adopt/listAdopt.jsp";      
	}
}