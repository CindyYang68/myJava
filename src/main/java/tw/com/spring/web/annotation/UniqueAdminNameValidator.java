package tw.com.spring.web.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import tw.com.spring.web.service.AdminService;


@Component
public class UniqueAdminNameValidator implements ConstraintValidator<UniqueAdminName, String> {
    @Autowired
    private AdminService aService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return (aService.findAdminByName(name) == null);
    }
}
