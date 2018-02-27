package biz.cosee.talks.beanvalidation.validation.step2;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserIsRegisteredValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIsRegistered {

    String message() default "This user needs to be registered first in service XYZ.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}