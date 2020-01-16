package model.service;

import java.sql.SQLException;
import java.util.List;

import model.AdoptDTO;
import model.MemberDTO;
import model.PetDTO;
import model.dao.PetDAO;


public class PetManager {
	private static PetManager petMgr = new PetManager();
	private PetDAO petDAO;
	
	private PetManager() {
		try{
			petDAO = new PetDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PetManager getInstance() {
		return petMgr;
	}
	
	public int create(PetDTO pet) throws SQLException, ExistingMemberException {	
		return petDAO.create(pet);
	}
	
	public int update(PetDTO pet) throws SQLException {
		return petDAO.update(pet);
	}	

	public int remove(String userId, int petId) throws SQLException {
		return petDAO.remove(userId, petId);
	}
	
	
	/** 사용자 id로 pet 정보 찾기 **/
	public List<PetDTO> findMyPetList(String userId) 
			throws SQLException, MemberNotFoundException{
		return petDAO.findMyPetList(userId);
	
	}
	
	public PetDTO findPet(String userId, int adoptId) 
			throws SQLException, MemberNotFoundException{
		PetDTO pet = petDAO.findPet(userId, adoptId);
		
		return pet;
	}
	
	public PetDAO getAdoptDAO() {
		return this.petDAO;
	}
}