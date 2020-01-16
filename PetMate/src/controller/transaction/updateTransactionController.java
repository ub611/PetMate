package controller.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.SellDTO;
import model.dao.TransactionDAO;

public class updateTransactionController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SellDTO dto = new SellDTO();
		TransactionDAO dao = new TransactionDAO();
		
		dto = dao.findSellId(Integer.parseInt(request.getParameter("id")));
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setItem_price(Integer.parseInt(request.getParameter("price")));
		
		dao.update(dto);
		
		return "redirect:/member/registerSell/form";
	}

}
