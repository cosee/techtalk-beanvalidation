package biz.cosee.talks.beanvalidation.validation.step1;

import org.springframework.stereotype.Service;

@Service
public class StreetNameChecker {

    public boolean streetNameExists(String streetName) {
        return true;
    }
}
