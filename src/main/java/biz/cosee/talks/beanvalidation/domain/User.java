package biz.cosee.talks.beanvalidation.domain;

import biz.cosee.talks.beanvalidation.validation.step2.UserIsRegistered;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class User {

    @NotEmpty
    @Size(max = 2, message = "{my.custom.size.message}")
    private String firstName;

    @NotEmpty
    @Size(max = 255)
    private String lastName;

    @Min(value = 18)
    @Max(value = 150)
    private int age;

    @Valid
    private Address address;


}
