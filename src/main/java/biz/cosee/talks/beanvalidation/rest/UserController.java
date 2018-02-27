package biz.cosee.talks.beanvalidation.rest;

import biz.cosee.talks.beanvalidation.domain.User;
import biz.cosee.talks.beanvalidation.usecase.AnalyseUserService;
import biz.cosee.talks.beanvalidation.validation.step4.CustomValidationExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final Validator validator;
    private final AnalyseUserService analyseUserService;

    @Autowired
    public UserController(Validator validator, AnalyseUserService analyseUserService) {
        this.validator = validator;
        this.analyseUserService = analyseUserService;
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setUser(@PathVariable("userId") String userId,
                        @RequestBody NewUserDto newUserDto) {

        User user = mapToUser(newUserDto);

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if (!constraintViolations.isEmpty()) {
            throw CustomValidationExceptionBuilder.throwValidationException(constraintViolations);
        } else {
            return "This user looks fine!";
        }

    }

    private User mapToUser(NewUserDto newUserDto) {
        User user = new User();
        user.setFirstName(newUserDto.getFirstName());
        user.setLastName(newUserDto.getLastName());
        user.setAge(newUserDto.getAge());
        return user;
    }

}
