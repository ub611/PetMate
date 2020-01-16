package controller.transaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.SellDTO;
import model.dao.TransactionDAO;

public class priceTransactionController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TransactionDAO dao = new TransactionDAO();
		List<SellDTO> sellList = dao.priceSellList();

		request.setAttribute("sellList", sellList);				
		request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		
		
		return "/transaction/listTransaction.jsp";
	}
}
