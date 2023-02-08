package tw.com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.spring.web.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);
	Admin findByName(String name);
	
}
