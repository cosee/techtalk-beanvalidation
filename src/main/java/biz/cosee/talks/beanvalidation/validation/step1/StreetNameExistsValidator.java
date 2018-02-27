package biz.cosee.talks.beanvalidation.validation.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class StreetNameExistsValidator implements ConstraintValidator<StreetNameExists, String> {

    private final StreetNameChecker streetNameChecker;

    @Autowired
    public StreetNameExistsValidator(StreetNameChecker streetNameChecker) {
        this.streetNameChecker = streetNameChecker;
    }

    @Override
    public void initialize(StreetNameExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        return streetNameChecker.streetNameExists(value);
    }
}