package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdoptDTO;
import model.PetDTO;

public class PetDAO {
	private JDBCUtil jdbcUtil = null;
	
	public PetDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	/** pet 등록 **/
	public int create(PetDTO pet) throws SQLException {
		String sql = "INSERT INTO PET VALUES (?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { pet.getUserID(),
				pet.getPet_ID(), pet.getKind_ID(),
				pet.getPet_age(), pet.getPet_gender(), pet.getPet_name() };
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}
	
	
	/** pet 정보 수정 **/
	public int update(PetDTO pet) throws SQLException {
		String sql = "UPDATE PET " 
				+ "SET pet_name=?, pet_age=?, pet_gender=? "
				+ "WHERE userid=? and pet_id=?";
	
		Object[] param = new Object[] {
				pet.getPet_name(), pet.getPet_age(), pet.getPet_gender(),
				pet.getUserID(), pet.getPet_ID() };
		
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	
	/** pet 삭제 **/
	public int remove(String userID, int pet_id) throws SQLException {
		String sql = "DELETE FROM PET WHERE userid=? and pet_id=?";
		Object[] param = new Object[] { userID, pet_id };
		jdbcUtil.setSqlAndParameters(sql, param);
		
		System.out.println("remove: " + userID + " " + pet_id);
		
		try {
			int result = jdbcUtil.executeUpdate();	
			return result;
		}catch(Exception e){
			jdbcUtil.rollback();
			e.printStackTrace();
		}finally{
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;	
	}
	
	/** 사용자 등록 pet 정보보기 **/
	public List<PetDTO> findMyPetList(String userId) throws SQLException {
		String sql = "SELECT kind_id, pet_age, pet_gender, pet_name, pet_id "
				+ "FROM PET WHERE userid=? ORDER BY kind_id";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId });
		
		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<PetDTO> petList = new ArrayList<PetDTO>();
			
			while (rs.next()) {
				PetDTO pet = new PetDTO(
						userId,
						rs.getInt("pet_id"),
						rs.getString("kind_id"),
						rs.getString("pet_age"),
						rs.getString("pet_gender"),
						rs.getString("pet_name"));
				
				petList.add(pet);
			}	
			return petList;
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;		
	}
	
	/** pet 수정을 위해 정보 찾기 **/
	public PetDTO findPet(String userId, int petId) throws SQLException {
		String sql = "SELECT pet_name, pet_age, kind_id, pet_gender "
				+ "FROM PET WHERE pet_id=? and userid=?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { petId, userId });
		
		try{
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				PetDTO pet = new PetDTO(
						userId,
						petId,
						rs.getString("kind_id"),
						rs.getString("pet_age"),
						rs.getString("pet_gender"),
						rs.getString("pet_name"));
				
				return pet;	
			}	
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;		
	}
}
