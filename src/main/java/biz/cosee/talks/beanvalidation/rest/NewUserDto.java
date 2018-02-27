package biz.cosee.talks.beanvalidation.rest;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class NewUserDto {

    private String firstName;

    private String lastName;

    private int age;

}
