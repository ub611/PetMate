package controller.adopt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.AdoptDTO;
import model.service.AdoptManager;

public class ViewAdoptController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      
      AdoptDTO adopt = null;
      AdoptManager manager = AdoptManager.getInstance();
      String userId = request.getParameter("userId");
      int adopt_id = Integer.parseInt(request.getParameter("adoptId"));
      
      try{
         adopt = manager.findAdopt(userId, adopt_id);   //입양 id로 검색
      }catch(Exception e){
         return "redirect:/adopt/listAdopt.jsp";   
      }
      
      request.setAttribute("adopt", adopt);   //입양 정보 저장
      
      String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
      if(curUserId != null && curUserId.equals(userId) == false) {
    	  //userId와 세션 Id가 다를 경우 
    	  return "/adopt/viewAdopt.jsp";	//입양 상세보기로 화면 이동
      }
      
      //로그인 안되도 입양 상세보기 가능
		if (!UserSessionUtils.isLogined(request.getSession())) {
			request.setAttribute("NotLogin", true);
	    	 request.setAttribute("msg", "로그인 후 작성가능합니다.");
          return "/adopt/viewAdopt.jsp";
      }
     
      return "/adopt/viewMyAdopt.jsp";   //입양 수정, 삭제로 화면 이동
   }

}