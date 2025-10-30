package com.example.hmrback.validation;

import com.example.hmrback.validation.validator.DateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Invalid publication date (must be in format dd/MM/yyyy and not in the future)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
