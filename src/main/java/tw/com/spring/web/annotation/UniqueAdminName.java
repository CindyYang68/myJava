package tw.com.spring.web.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UniqueAdminNameValidator.class)
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueAdminName {
    String message() default "此帳號已被使用，請換一組";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
