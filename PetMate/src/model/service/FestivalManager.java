package model.service;

import java.sql.SQLException;
import java.util.List;

import model.FestivalDTO;
import model.dao.FestivalDAO;

public class FestivalManager {
	private static FestivalManager festivalMgr = new FestivalManager();
	private FestivalDAO festivalDAO;
	
	private FestivalManager() {
		try{
			festivalDAO= new FestivalDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static FestivalManager getInstance() {
		return festivalMgr;
	}
	public List<FestivalDTO> findFestivalList(String region) throws SQLException {
		return festivalDAO.findFestival(region);
	}
}
