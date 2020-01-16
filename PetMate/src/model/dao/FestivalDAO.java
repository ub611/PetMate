package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FestivalDTO;

public class FestivalDAO {
	private JDBCUtil jdbcUtil = null;

	public FestivalDAO() {
		jdbcUtil = new JDBCUtil();	//jdbcutil°´Ã¼ »ý¼º
	}
	
	public List<FestivalDTO> findFestival(String con) throws SQLException {
        String sql = "SELECT festival_title, festival_date, festival_place "
        			+ "FROM festival WHERE festival_place=? order by festival_date desc";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {con});
		List<FestivalDTO> festivalList = new ArrayList<FestivalDTO>();
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			
		while(rs.next()){
			FestivalDTO festival = new FestivalDTO(rs.getString("festival_title"),rs.getDate("festival_date"),rs.getString("festival_place"));
			festivalList.add(festival);
		}

		return festivalList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
