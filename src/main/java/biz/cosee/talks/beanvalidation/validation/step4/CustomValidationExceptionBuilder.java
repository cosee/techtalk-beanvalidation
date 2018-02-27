package biz.cosee.talks.beanvalidation.validation.step4;

import biz.cosee.talks.beanvalidation.domain.User;
import com.google.common.collect.Iterators;

import javax.validation.ConstraintViolation;
import javax.validation.ElementKind;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomValidationExceptionBuilder {

    public static MyCustomValidationException throwValidationException(Set<ConstraintViolation<User>> constraintViolations) {
        String failureString = constraintViolations
                .stream()
                .map(CustomValidationExceptionBuilder::buildViolationString)
                .collect(Collectors.joining(System.lineSeparator()));

        return new MyCustomValidationException(failureString);
    }

    private static String buildViolationString(ConstraintViolation<User> violation) {
        if (Iterators.getLast(violation.getPropertyPath().iterator()).getKind().equals(ElementKind.BEAN)) {
            return violation.getMessage() + ".";
        } else {
            return String.format("Field '%s' with value: '%s' %s.", violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage());
        }
    }
}
