package com.spring.ex03;

public class MemberDAOImpl implements MemberDAO{
	private MemberDAO MemberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		MemberDAO = memberDAO;
	}

	@Override
	public void listMembers() {
		System.out.println("listMembers 메서드 호출");
		System.out.println("회원정보를 조회합니다.");
	}
	
}
