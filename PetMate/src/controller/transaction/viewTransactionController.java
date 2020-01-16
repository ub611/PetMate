package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.SellDTO;
import model.dao.TransactionDAO;

public class viewTransactionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		SellDTO sell = new SellDTO();
		TransactionDAO dao = new TransactionDAO();
		
		int sellId = Integer.parseInt(request.getParameter("sellId"));
		String userId = request.getParameter("userId");

	     try{
	         sell = dao.findSell(userId, sellId);   
	      }catch(Exception e){
	         return "redirect:/transaction/listTransaction.jsp";   
	      }
	      
	      request.setAttribute("sell", sell);   
	      
	      String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
	      if(curUserId != null && curUserId.equals(userId) == false) {
	    	  //userId와 세션 Id가 다를 경우 
	    	  return "/transaction/viewTransaction.jsp";	
	      }
	      
	      //로그인 안되도 보기 가능
	      if (!UserSessionUtils.isLogined(request.getSession())) {
	    	  request.setAttribute("NotLogin", true);
	    	  request.setAttribute("msg", "로그인 후 작성가능합니다.");
	          return "/transaction/viewTransaction.jsp";
	      }
	     
	      return "/transaction/viewMyTransaction.jsp";   
	}

}
