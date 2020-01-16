package controller.adopt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.AdoptDTO;
import model.service.AdoptManager;

public class UpdateAdoptFormController implements Controller{
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		int adopt_id = Integer.parseInt(request.getParameter("adoptId"));
		String kind = request.getParameter("kind");
		
		AdoptManager manager = AdoptManager.getInstance();
		AdoptDTO adopt = manager.findAdopt(userId, adopt_id);	// 입양 정보 검색
		request.setAttribute("user", adopt);		// 입양 정보 저장				
		
	    try{
	         adopt = manager.findAdopt(userId, adopt_id);   //입양 id로 검색
	    }catch(Exception e){
	    	request.setAttribute("kind", kind);
	    	return "/adopt/listAdopt";   
	          //리스트 컨트롤러 거쳐서 리스트 출력 화면으로 ("redirect:/member/registerAdopt/form")
	    }
	       
       request.setAttribute("adopt", adopt);   //입양 정보 저장
       
       return "/adopt/updateAdopt.jsp";   //입양 정보 수정 페이지     
     }
}
