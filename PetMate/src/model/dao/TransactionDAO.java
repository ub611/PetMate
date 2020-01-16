package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdoptDTO;
import model.MemberDTO;
import model.SellDTO;

public class TransactionDAO {
	private JDBCUtil jdbcUtil = null;

	public TransactionDAO() {
		jdbcUtil = new JDBCUtil();	//jdbcutil객체 생성
	}
	
	public int create(SellDTO sell) throws SQLException {
	      String sql = "INSERT INTO SELL VALUES (?, ?, ?, ?, ?, ?)";
	      Object[] param = new Object[] { sell.getUserID(),
	            1, sell.getItem_kind_ID(), sell.getItem_price(), sell.getTitle(), sell.getContent() };
	      
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
	
	/**  리스트 반환 **/
	public List<SellDTO> findSellList() throws SQLException {
        String sql = "SELECT userid, sell_id, item_kind_id, item_price, item_title, item_content " 
        		   + "FROM SELL";
        
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<SellDTO> sellList = new ArrayList<SellDTO>();
			
			while (rs.next()) {
				SellDTO sell = new SellDTO();
				sell.setUserID(rs.getString("userid"));
				sell.setSell_ID(Integer.parseInt(rs.getString("sell_id")));
				sell.setItem_kind_ID(rs.getString("item_kind_id"));
				sell.setItem_price(Integer.parseInt(rs.getString("item_price")));
				sell.setTitle(rs.getString("item_title"));
				sell.setContent(rs.getString("item_content"));
				sellList.add(sell);	
			}		
			return sellList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/** 물품 상세보기 반환 **/
	public SellDTO findSell(String userId, int sellId) throws SQLException {
		String sql = "SELECT item_title, item_kind_ID, item_content, item_price "
				+ "FROM SELL WHERE sell_id=? and userid=?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { sellId, userId });
		
		try{
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				SellDTO sell = new SellDTO(
						userId,
						sellId,
						rs.getString("item_kind_ID"),
						rs.getInt("item_price"),
						rs.getString("item_title"),
						rs.getString("item_content"));	
				return sell;	
			}	
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;		
	}
	
	public SellDTO findSellId(int sellId) throws SQLException {
		String sql = "SELECT userid, item_title, item_kind_ID, item_content, item_price "
				+ "FROM SELL WHERE sell_id=?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { sellId });
		
		try{
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				SellDTO sell = new SellDTO(
						rs.getString("userid"),
						sellId,
						rs.getString("item_kind_ID"),
						rs.getInt("item_price"),
						rs.getString("item_title"),
						rs.getString("item_content"));	
				return sell;	
			}	
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;		
	}
	
	//물품거래 수정
	public int update(SellDTO sell) throws SQLException {
		String sql = "UPDATE SELL "
					+ "SET item_title=?, item_content=?, item_price=?"
					+ " WHERE sell_id=?";
		
		Object[] param = new Object[] {sell.getTitle(), sell.getContent(), sell.getItem_price(), sell.getSell_ID()};				
		jdbcUtil.setSqlAndParameters(sql, param);
			
		try {				
			int result = jdbcUtil.executeUpdate();
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
	
	public int remove(String userId, int sellId) throws  SQLException {
		String sql = "DELETE FROM SELL WHERE userid=? and sell_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, sellId});
		
		try{
			int result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	//가격순 정렬
	public List<SellDTO> priceSellList() throws SQLException {
        String sql = "SELECT userid, sell_id, item_kind_id, item_price, item_title, item_content " 
        		   + "FROM SELL ORDER BY item_price";
        
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<SellDTO> sellList = new ArrayList<SellDTO>();
			
			while (rs.next()) {
				SellDTO sell = new SellDTO();
				sell.setUserID(rs.getString("userid"));
				sell.setSell_ID(Integer.parseInt(rs.getString("sell_id")));
				sell.setItem_kind_ID(rs.getString("item_kind_id"));
				sell.setItem_price(Integer.parseInt(rs.getString("item_price")));
				sell.setTitle(rs.getString("item_title"));
				sell.setContent(rs.getString("item_content"));
				sellList.add(sell);	
			}		
			return sellList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	public List<SellDTO> highpriceSellList() throws SQLException {
        String sql = "SELECT userid, sell_id, item_kind_id, item_price, item_title, item_content " 
        		   + "FROM SELL ORDER BY item_price DESC";
        
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<SellDTO> sellList = new ArrayList<SellDTO>();
			
			while (rs.next()) {
				SellDTO sell = new SellDTO();
				sell.setUserID(rs.getString("userid"));
				sell.setSell_ID(Integer.parseInt(rs.getString("sell_id")));
				sell.setItem_kind_ID(rs.getString("item_kind_id"));
				sell.setItem_price(Integer.parseInt(rs.getString("item_price")));
				sell.setTitle(rs.getString("item_title"));
				sell.setContent(rs.getString("item_content"));
				sellList.add(sell);	
			}		
			return sellList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}