package biz.cosee.talks.beanvalidation.validation.step1;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StreetNameExistsValidator.class)
public @interface StreetNameExists {

    String message() default "is no valid street name";

    // Required by validation runtime
    Class<?>[] groups() default {};

    // Required by validation runtime
    Class<? extends StreetNameExists>[] payload() default {};
}