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
         adopt = manager.findAdopt(userId, adopt_id);   //�Ծ� id�� �˻�
      }catch(Exception e){
         return "redirect:/adopt/listAdopt.jsp";   
      }
      
      request.setAttribute("adopt", adopt);   //�Ծ� ���� ����
      
      String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
      if(curUserId != null && curUserId.equals(userId) == false) {
    	  //userId�� ���� Id�� �ٸ� ��� 
    	  return "/adopt/viewAdopt.jsp";	//�Ծ� �󼼺���� ȭ�� �̵�
      }
      
      //�α��� �ȵǵ� �Ծ� �󼼺��� ����
		if (!UserSessionUtils.isLogined(request.getSession())) {
			request.setAttribute("NotLogin", true);
	    	 request.setAttribute("msg", "�α��� �� �ۼ������մϴ�.");
          return "/adopt/viewAdopt.jsp";
      }
     
      return "/adopt/viewMyAdopt.jsp";   //�Ծ� ����, ������ ȭ�� �̵�
   }

}