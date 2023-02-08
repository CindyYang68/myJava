package tw.com.spring.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import tw.com.spring.web.model.Admin;
import tw.com.spring.web.repository.AdminRepository;
import tw.com.spring.web.service.AdminService;

@Service
@Validated
public class AdminService  {

	@Autowired
	private AdminRepository aRepository;
	
	@Autowired
    private Validator validator;
	
	
	public Integer addAdmin(Admin admin) {
		Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Admin> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }
        Admin newAdmin = aRepository.save(admin);
        return newAdmin.getId();
    
    }

	public Admin findAdminByEmail(String email) {
		return aRepository.findByEmail(email);
	}

	public Admin findAdminByName(String name) {
		 return aRepository.findByName(name);
	}
	
	public Admin loginAdminByName(String name) throws NotFoundException {
		
		Admin admin=aRepository.findByName(name);
		if(admin !=null) {
			return admin;
		}else {
			return null;
		}
		
		  
	}
	
}
