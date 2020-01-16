package model.service;

import java.sql.SQLException;
import java.util.List;

import model.AdoptDTO;
import model.dao.AdoptDAO;


public class AdoptManager {
	private static AdoptManager adoptMgr = new AdoptManager();
	private AdoptDAO adoptDAO;
	
	private AdoptManager() {
		try{
			adoptDAO = new AdoptDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static AdoptManager getInstance() {
		return adoptMgr;
	}
	
	public int update(AdoptDTO adopt) throws SQLException {
		return adoptDAO.update(adopt);
	}	

	public int remove(String userId, int adoptId) throws SQLException {
		return adoptDAO.remove(userId, adoptId);
	}
	
	//리스트 출력
	public List<AdoptDTO> findAdoptList(String kind) throws SQLException {
		return adoptDAO.findAdoptList(kind);
	}
	
	
	/**입양 id로 상세 정보 찾기 **/
	public AdoptDTO findAdopt(String userId, int adoptId) 
			throws SQLException, MemberNotFoundException{
		AdoptDTO adopt = adoptDAO.findAdopt(userId, adoptId);
		
//		if(adopt == null){
//			throw new MemberNotFoundException(adoptId + "는 존재하지 않습니다");
//		}
		return adopt;
	}
	
	public AdoptDAO getAdoptDAO() {
		return this.adoptDAO;
	}
}