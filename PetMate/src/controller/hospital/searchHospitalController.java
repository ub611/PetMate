package controller.hospital;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.HospitalDTO;
import model.service.HospitalManager;

public class searchHospitalController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String time = request.getParameter("time");
		
		HospitalManager manager = HospitalManager.getInstance();

		List<HospitalDTO> hospitalList = manager.findHospitalList(time);
		
		request.setAttribute("hospitalList", hospitalList);				
		
//		return "/hospital/searchHospital_list.jsp"; 
		return "/hospital/list/form";
	}

}
