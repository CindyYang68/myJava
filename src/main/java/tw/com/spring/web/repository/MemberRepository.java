package tw.com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.spring.web.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	
}
