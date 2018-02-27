package biz.cosee.talks.beanvalidation.validation.step3;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, SimpleChecks.class, ComplexChecks.class })
public interface GroupValidationSequence {
}