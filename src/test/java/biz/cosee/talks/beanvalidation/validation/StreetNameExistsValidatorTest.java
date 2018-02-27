package biz.cosee.talks.beanvalidation.validation;

import biz.cosee.talks.beanvalidation.domain.Address;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class StreetNameExistsValidatorTest extends MockableCustomConstraintValidatorTest {

    @Test
    public void validationOkForValidAddress() {
        Address validAddress = createValidAddress();
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(validAddress);
        Assertions.assertThat(constraintViolations.size()).isZero();
    }

    @Test
    public void validationFailsForNonExistentStreetName() {
        Mockito.when(streetNameChecker.streetNameExists("highstreet")).thenReturn(false);

        Address address = createValidAddress();
        address.setStreetName("highstreet");

        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);

        Assertions.assertThat(constraintViolations.size()).isEqualTo(1);
    }

    private Address createValidAddress() {
        Address address = new Address();
        address.setStreetName("street");
        address.setStreetNumber(16);
        return address;
    }
}
