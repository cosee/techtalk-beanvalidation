package biz.cosee.talks.beanvalidation.validation.step2;

import biz.cosee.talks.beanvalidation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UserIsRegisteredValidator implements ConstraintValidator<UserIsRegistered, User> {

    private final UserIsRegisteredChecker userIsRegisteredChecker;

    @Autowired
    public UserIsRegisteredValidator(UserIsRegisteredChecker userIsRegisteredChecker) {
        this.userIsRegisteredChecker = userIsRegisteredChecker;
    }

    @Override
    public void initialize(UserIsRegistered constraintAnnotation) {

    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return userIsRegisteredChecker.assertUserIsRegistered(value);
    }

}