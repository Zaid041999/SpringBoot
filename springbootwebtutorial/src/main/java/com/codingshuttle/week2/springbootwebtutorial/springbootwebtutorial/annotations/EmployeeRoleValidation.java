package com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {EmployeeRoleValidator.class}
)
public @interface EmployeeRoleValidation {
    //error message
    String message() default "Role of Employee can either be USER or ADMIN";

    //represent group of constraints
    Class<?>[] groups() default {};

    //additional information about annotation
    Class<? extends Payload>[] payload() default {};
}
