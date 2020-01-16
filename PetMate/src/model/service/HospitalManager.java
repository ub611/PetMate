package model.service;

import java.sql.SQLException;
import java.util.List;

import model.AdoptDTO;
import model.HospitalDTO;
import model.dao.AdoptDAO;
import model.dao.HospitalDAO;

public class HospitalManager {
	private static HospitalManager hospitalMgr = new HospitalManager();
	private HospitalDAO hospitalDAO;
	
	private HospitalManager() {
		try{
			hospitalDAO = new HospitalDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static HospitalManager getInstance() {
		return hospitalMgr;
	}
	public List<HospitalDTO> findHospitalList(String time) throws SQLException {
		return hospitalDAO.findHospital(time);
	}
}
