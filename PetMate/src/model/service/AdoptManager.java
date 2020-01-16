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
	
	//����Ʈ ���
	public List<AdoptDTO> findAdoptList(String kind) throws SQLException {
		return adoptDAO.findAdoptList(kind);
	}
	
	
	/**�Ծ� id�� �� ���� ã�� **/
	public AdoptDTO findAdopt(String userId, int adoptId) 
			throws SQLException, MemberNotFoundException{
		AdoptDTO adopt = adoptDAO.findAdopt(userId, adoptId);
		
//		if(adopt == null){
//			throw new MemberNotFoundException(adoptId + "�� �������� �ʽ��ϴ�");
//		}
		return adopt;
	}
	
	public AdoptDAO getAdoptDAO() {
		return this.adoptDAO;
	}
}