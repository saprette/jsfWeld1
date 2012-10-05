package com.corejsf;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LuhnCheckValidator.class)
public @interface LuhnCheck {
    String message() default "{com.corejsf.LuhnCheck.message}";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
