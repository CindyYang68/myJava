package tw.com.spring.web.service;

import java.util.List;

import tw.com.spring.web.model.Member;

public interface MemberService {

	List<Member> getAllMembers();
	
	void addMember(Member member);
	
	Member updateMemberById(Long id);
	
	void deleteMember(Long id);
	
	
	
}
