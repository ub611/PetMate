package model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MemberDTO;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ���� 
 */

public class MemberDAO {
	private JDBCUtil jdbcUtil = null;

	public MemberDAO() {
		jdbcUtil = new JDBCUtil();	//jdbcutil��ü ����
	}
	

	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
	 */
	
	public int create(MemberDTO user) throws SQLException {
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserID(), user.getPwd(), 
						user.getName(), user.getRegion()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}
	
	///////////////////////////////////////////////////////
	
	/**
	 * ������ ����� ������ ����.
	 */
	public int update(MemberDTO user) throws SQLException {
		String sql = "UPDATE MEMBER "
					+ "SET pwd=?, name=?, region=?"
					+ "WHERE userid=?";
		Object[] param = new Object[] {user.getPwd(), user.getName(), user.getRegion(), user.getUserID()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
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

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String userID) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE userid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userID});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
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

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public MemberDTO findMember(String userID) throws SQLException {
        String sql = "SELECT pwd, name, region "
        			+ "FROM MEMBER WHERE userid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userID});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				MemberDTO user = new MemberDTO(		// User ��ü�� �����Ͽ� �л� ������ ����
					userID,
					rs.getString("pwd"),
					rs.getString("name"),
					rs.getString("region"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<MemberDTO> findMemberList() throws SQLException {
        String sql = "SELECT userID, pwd, name, region " 
        		   + "FROM MEMBER ORDER BY userID";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<MemberDTO> userList = new ArrayList<MemberDTO>();	// User���� ����Ʈ ����
			while (rs.next()) {
				MemberDTO user = new MemberDTO(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
					rs.getString("userID"),
					rs.getString("pwd"),
					rs.getString("name"),
					rs.getString("region"));	
				userList.add(user);				// List�� User ��ü ����
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * ��ü ����� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ�
	 * �ش��ϴ� ����� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<MemberDTO> findMemberList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT userID, pwd, name, region " 
        		   + "FROM MEMBER ORDER BY userID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<MemberDTO> userList = new ArrayList<MemberDTO>();	// User���� ����Ʈ ����
				do {
					MemberDTO user = new MemberDTO(		// User ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getString("userID"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getString("region"));	
					userList.add(user);							// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����ڰ� �����ϴ��� �˻� 
	 */
	public boolean existingMember(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBER WHERE userid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}


}

