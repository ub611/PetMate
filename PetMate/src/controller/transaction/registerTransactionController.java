package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.SellDTO;
import model.dao.TransactionDAO;

public class registerTransactionController implements Controller{

	private TransactionDAO dao = new TransactionDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession()); 
		
		SellDTO sell = new SellDTO(curUserId,1,request.getParameter("transaction_kind"), Integer.parseInt(request.getParameter("price")),
				request.getParameter("title"),request.getParameter("content"));
		
//		sell.setUserID(curUserId);
//		sell.setSell_ID(String.valueOf(1));
//		sell.setItem_price(Integer.parseInt(request.getParameter("price")));
//		sell.setItem_kind_ID(request.getParameter("transaction_kind"));
//		sell.setTitle(request.getParameter("title"));
//		sell.setContent(request.getParameter("content"));
		
		dao.create(sell);
		
		return "/member/registerSell/form";
	}

}
