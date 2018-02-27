package biz.cosee.talks.beanvalidation.validation.step2;

import biz.cosee.talks.beanvalidation.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserIsRegisteredChecker {

    public boolean assertUserIsRegistered(User user) {
        return true;
    }
}
