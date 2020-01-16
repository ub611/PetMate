package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.MemberDTO;
import model.dao.MemberDAO;

// a Business Class
public class MemberAnalysis {
	private MemberDAO dao;
	
	public MemberAnalysis() {}
	
	public MemberAnalysis(MemberDAO dao) {
		super();
		this.dao = dao;
	}

	public List<MemberDTO> recommendFriends(String userId) throws Exception {		
		
		MemberDTO curmember = dao.findMember(userId);
		if (curmember == null) {
			return null;
		}		
		
		String server1 = curmember.getRegion();
		
		List<MemberDTO> friends = new ArrayList<MemberDTO>();
		
		List<MemberDTO> memberList = dao.findMemberList(1, 10000);
		Iterator<MemberDTO> memberIter = memberList.iterator();		
		while (memberIter.hasNext()) {
			MemberDTO member = (MemberDTO)memberIter.next();
			
			if (member.getUserID().equals(userId)) continue;
			
			String server2 = member.getRegion();

			if (server1.equals(server2)) 
				friends.add(member);		
		}
		return friends;
	}
}
