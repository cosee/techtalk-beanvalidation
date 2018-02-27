package biz.cosee.talks.beanvalidation.domain;

import biz.cosee.talks.beanvalidation.validation.step1.StreetNameExists;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Address {

    @NotEmpty
    @Size(max = 255)
    @StreetNameExists
    private String streetName;

    @NotNull
    private Integer streetNumber;

}
