package model.service;

import java.sql.*;
import java.util.List;

import model.MemberDTO;
import model.dao.MemberDAO;

public class MemberManager {
	private static MemberManager MemMgr = new MemberManager();
	private MemberDAO memberDAO;
	
	private MemberManager() {
		try{
			memberDAO = new MemberDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberManager getInstance() {
		return MemMgr;
	}
	
	public int create(MemberDTO user) throws SQLException, ExistingMemberException {
		if (memberDAO.existingMember(user.getUserID()) == true) {
			throw new ExistingMemberException(user.getUserID() + "는 존재하는 아이디입니다.");
		}
		return memberDAO.create(user);
	}

	public int update(MemberDTO user) throws SQLException {
		return memberDAO.update(user);
	}	

	public int remove(String userID) throws SQLException {
		return memberDAO.remove(userID);
	}

	public MemberDTO findUser(String userId)
		throws SQLException, MemberNotFoundException {
		MemberDTO user = memberDAO.findMember(userId);
		
		if (user == null) {
			throw new MemberNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}		
		return user;
	}

	public List<MemberDTO> findUserList() throws SQLException {
			return memberDAO.findMemberList();
	}
	
	public List<MemberDTO> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return memberDAO.findMemberList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, MemberNotFoundException, PasswordMismatchException {
		MemberDTO user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	
	public MemberDAO getUserDAO() {
		return this.memberDAO;
	}
	
}
