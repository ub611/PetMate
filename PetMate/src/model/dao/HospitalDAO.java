package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdoptDTO;
import model.HospitalDTO;


public class HospitalDAO {
	private JDBCUtil jdbcUtil = null;

	public HospitalDAO() {
		jdbcUtil = new JDBCUtil();	//jdbcutil객체 생성
	}
	
	//마감시간을 조건으로 병원찾기
	public List<HospitalDTO> findHospital(String con) throws SQLException {
        String sql = "SELECT hospital_name, hospital_address, hospital_closed "
        			+ "FROM hospital WHERE hospital_closed=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {con});
		List<HospitalDTO> hospitalList = new ArrayList<HospitalDTO>();
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			
		while(rs.next()){
			HospitalDTO hospital = new HospitalDTO();
			hospital.setHospital_name(rs.getString("hospital_name"));
			hospital.setHospital_address(rs.getString("hospital_address"));
			hospital.setHospital_closed(rs.getString("hospital_closed"));
			hospitalList.add(hospital);
		}

		return hospitalList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
