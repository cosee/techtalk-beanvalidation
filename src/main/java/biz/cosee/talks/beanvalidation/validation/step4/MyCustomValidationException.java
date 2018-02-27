package biz.cosee.talks.beanvalidation.validation.step4;

public class MyCustomValidationException extends RuntimeException {
    public MyCustomValidationException(String failureString) {
        super(failureString);
    }
}
