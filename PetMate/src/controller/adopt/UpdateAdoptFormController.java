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
		AdoptDTO adopt = manager.findAdopt(userId, adopt_id);	// �Ծ� ���� �˻�
		request.setAttribute("user", adopt);		// �Ծ� ���� ����				
		
	    try{
	         adopt = manager.findAdopt(userId, adopt_id);   //�Ծ� id�� �˻�
	    }catch(Exception e){
	    	request.setAttribute("kind", kind);
	    	return "/adopt/listAdopt";   
	          //����Ʈ ��Ʈ�ѷ� ���ļ� ����Ʈ ��� ȭ������ ("redirect:/member/registerAdopt/form")
	    }
	       
       request.setAttribute("adopt", adopt);   //�Ծ� ���� ����
       
       return "/adopt/updateAdopt.jsp";   //�Ծ� ���� ���� ������     
     }
}
