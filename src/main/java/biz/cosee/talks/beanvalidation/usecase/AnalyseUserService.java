package biz.cosee.talks.beanvalidation.usecase;

import biz.cosee.talks.beanvalidation.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

@Service
@Slf4j
@Validated
public class AnalyseUserService {
    public void performSomeLogicOnNewUser(@Valid User user) {
      log.info("performing some logic on new user");
        //Some complex logic is going on here
    }
}
