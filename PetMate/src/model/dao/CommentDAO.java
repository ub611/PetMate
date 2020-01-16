package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SellCommentDTO;

public class CommentDAO {
   private JDBCUtil jdbcUtil = null;

   public CommentDAO() {
      jdbcUtil = new JDBCUtil();
   }
   
   public int create(SellCommentDTO com) throws SQLException {
         String sql = "INSERT INTO COMMENT_SELL VALUES (?, ?, TO_DATE(?, 'yyyy-MM-dd'), ?, ?)";
         Object[] param = new Object[] { com.getUserid(),
               com.getSellid(), com.getTime(),
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
   public List<SellCommentDTO> findComList(String index) throws SQLException {
        String sql = "SELECT userid, comm_id_sell, comm_time, contents " 
                 + "FROM COMMENT_SELL WHERE COMM_IDX=?";
        Object[] param = new Object[]{ index };
        
      jdbcUtil.setSqlAndParameters(sql, param);
               
      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         List<SellCommentDTO> sellList = new ArrayList<SellCommentDTO>();
         
         while (rs.next()) {
            SellCommentDTO sell = new SellCommentDTO();
            sell.setUserid(rs.getString("userid"));
            sell.setSellid(Integer.parseInt(rs.getString("comm_id_sell")));
            sell.setTime(rs.getDate("comm_time"));
            sell.setContent(rs.getString("contents"));
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