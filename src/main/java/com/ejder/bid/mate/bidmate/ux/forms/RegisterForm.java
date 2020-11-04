package com.ejder.bid.mate.bidmate.ux.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterForm {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    @Size(min = 6)
    private String password;
    @NotBlank
    private boolean newsletter;
    @NotBlank
    private boolean terms;

    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @NotBlank
    private String number;
    @NotBlank
    private String postcode;
    @NotBlank
    private String street;

}
