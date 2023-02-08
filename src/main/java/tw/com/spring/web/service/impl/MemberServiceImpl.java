package tw.com.spring.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.spring.web.model.Member;
import tw.com.spring.web.repository.MemberRepository;
import tw.com.spring.web.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository mRepository;

	@Override
	public List<Member> getAllMembers() {
		
		return mRepository.findAll();
	}

	@Override
	public void addMember(Member member) {
		
		this.mRepository.save(member);
	}

	@Override
	public Member updateMemberById(Long id) {
		Optional<Member> optional=mRepository.findById(id);
		Member member=null;
		if(optional.isPresent()) {
			member=optional.get();
		}else {
			throw new RuntimeException("找不到 ID:"+id);
		}
		return member;
	}

	@Override
	public void deleteMember(Long id) {
		this.mRepository.deleteById(id);
		
		
	}

	
	
}
