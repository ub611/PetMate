package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.TransactionDAO;

public class deleteTransactionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TransactionDAO dao = new TransactionDAO();
		
		String userid = request.getParameter("userId");
		String sellid = request.getParameter("sellId");
		
		dao.remove(userid, Integer.parseInt(sellid));
		
		return "/member/registerSell/form";
	}

}
