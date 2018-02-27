package biz.cosee.talks.beanvalidation.validation;

import biz.cosee.talks.beanvalidation.validation.step1.StreetNameChecker;
import biz.cosee.talks.beanvalidation.validation.step2.UserIsRegisteredChecker;
import biz.cosee.talks.beanvalidation.validation.step1.StreetNameExistsValidator;
import biz.cosee.talks.beanvalidation.validation.step2.UserIsRegisteredValidator;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorFactoryImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@RunWith(MockitoJUnitRunner.class)
public abstract class MockableCustomConstraintValidatorTest implements ConstraintValidatorFactory {

    private ConstraintValidatorFactoryImpl constraintValidatorFactory = new ConstraintValidatorFactoryImpl();

    @Mock
    protected StreetNameChecker streetNameChecker;

    @Mock
    protected UserIsRegisteredChecker userIsRegisteredChecker;


    protected Validator validator;

    @Before
    public void setUp() {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        config.constraintValidatorFactory(this);

        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        if (key == StreetNameExistsValidator.class) {
            return (T) new StreetNameExistsValidator(streetNameChecker);
        } else if (key == UserIsRegisteredValidator.class) {
            return (T) new UserIsRegisteredValidator(userIsRegisteredChecker);
        } else {
            return constraintValidatorFactory.getInstance(key);
        }
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> instance) {

    }
}
