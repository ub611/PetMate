package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdoptCommentDTO;
import model.AdoptDTO;
import model.SellCommentDTO;

public class AdoptDAO {
	private JDBCUtil jdbcUtil = null;

	public AdoptDAO() {
		jdbcUtil = new JDBCUtil();	//jdbcutil��ü ����
	}
	
	/** ���� �߰�  **/
	public int create(AdoptDTO adopt) throws SQLException {
	      String sql = "INSERT INTO ADOPT VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'yyyy-MM-dd'))";
	      Object[] param = new Object[] { adopt.getUserID(),
	            adopt.getAdopt_ID(), adopt.getAdopt_price(),
	            adopt.getAdopt_age(), adopt.getAdopt_kind(), adopt.getAdopt_gender(),
	            adopt.getIs_adopted(), adopt.getAdopt_date() };
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
	
	/** ������ �Ծ� ���� ���� **/
	public int update(AdoptDTO adopt) throws SQLException {
		String sql = "UPDATE ADOPT " 
				+ "SET adopt_price=?, adopt_age=?, adopt_kind=?, adopt_gender=?, is_adopted=? "
				+ "WHERE userid=? and adopt_id=?";
	
		Object[] param = new Object[] {
				adopt.getAdopt_price(), adopt.getAdopt_age(),
				adopt.getAdopt_kind(), adopt.getAdopt_gender(), adopt.getIs_adopted(),
				adopt.getUserID(), adopt.getAdopt_ID() };
		
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}
	

	/** ����� id, �Ծ� id�� �ش��ϴ� ���� ���� **/
	public int remove(String userId, int adoptId) throws  SQLException {
		String sql = "DELETE FROM ADOPT WHERE userid=? and adopt_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, adoptId});
		
		try{
			int result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}
	
	
	/**  ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ **/
	public List<AdoptDTO> findAdoptList(String kind) throws SQLException {
        String sql = "SELECT userid, adopt_id, adopt_price, adopt_age, adopt_kind, adopt_gender, is_adopted, adopt_date " 
        		   + "FROM ADOPT WHERE adopt_kind=? ORDER BY adopt_date DESC";
        
		jdbcUtil.setSqlAndParameters(sql, new Object[]{ kind });
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<AdoptDTO> adoptList = new ArrayList<AdoptDTO>();
			
			while (rs.next()) {
				AdoptDTO adopt = new AdoptDTO();
				adopt.setUserID(rs.getString("userid"));
				adopt.setAdopt_ID(rs.getInt("adopt_id"));
				adopt.setAdopt_price(rs.getInt("adopt_price"));
				adopt.setAdopt_age(rs.getInt("adopt_age"));
				adopt.setAdopt_kind(kind);	
				adopt.setAdopt_gender(rs.getString("adopt_gender"));
				adopt.setIs_adopted(rs.getInt("is_adopted"));
				adopt.setAdopt_date(rs.getDate("adopt_date"));
				adoptList.add(adopt);	
			}		
			
			return adoptList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/** �Ծ� ID�� �Ծ� �󼼺��� ��ȯ **/
	public AdoptDTO findAdopt(String userId, int adoptId) throws SQLException {
		String sql = "SELECT adopt_price, adopt_age, adopt_kind, adopt_gender, is_adopted, adopt_date "
				+ "FROM ADOPT WHERE adopt_id=? and userid=?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { adoptId, userId });
		
		try{
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				AdoptDTO adopt = new AdoptDTO(
						userId,
						adoptId,
						rs.getInt("adopt_price"),
						rs.getInt("adopt_age"),
						rs.getString("adopt_kind"),
						rs.getString("adopt_gender"),
						rs.getInt("is_adopted"),
						rs.getString("adopt_date"));
				
				return adopt;	
			}	
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;		
	}
	
	//��۵��
	public int commentCreate(AdoptCommentDTO com) throws SQLException {
	      String sql = "INSERT INTO COMMENT_ADOPT VALUES (?, ?, TO_DATE(?, 'yyyy-MM-dd'), ?, ?)";
	      Object[] param = new Object[] { com.getUserid(),
	            com.getAdoptid(), com.getTime(),
	            com.getContent(), com.getIndex()};
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
	
	//��� ����Ʈ���
	public List<AdoptCommentDTO> findComList(String index) throws SQLException {
        String sql = "SELECT userid, comm_id_adopt, comm_time, contents " 
        		   + "FROM COMMENT_ADOPT WHERE COMM_IDX=?";
        Object[] param = new Object[]{ index };
        
		jdbcUtil.setSqlAndParameters(sql, param);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<AdoptCommentDTO> adoptList = new ArrayList<AdoptCommentDTO>();
			
			while (rs.next()) {
				AdoptCommentDTO sell = new AdoptCommentDTO();
				sell.setUserid(rs.getString("userid"));
				sell.setAdoptid(Integer.parseInt(rs.getString("comm_id_adopt")));
				sell.setTime(rs.getDate("comm_time"));
				sell.setContent(rs.getString("contents"));
				adoptList.add(sell);	
			}		
			return adoptList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}