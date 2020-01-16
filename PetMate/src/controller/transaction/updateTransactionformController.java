package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.SellDTO;
import model.dao.TransactionDAO;

public class updateTransactionformController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SellDTO sell = new SellDTO();
		TransactionDAO dao = new TransactionDAO();
		
		String userId = request.getParameter("userId");
		int sellId = Integer.parseInt(request.getParameter("sellId"));
		
	     try{
	         sell = dao.findSell(userId, sellId);
	      }catch(Exception e){
	         return "redirect:/transaction/listTransaction.jsp";   
	      }
	      
	     if(sell != null){
	      request.setAttribute("sell", sell);
	      return "/transaction/updateformTransaction.jsp";
	     }
		return null;
	}

}
