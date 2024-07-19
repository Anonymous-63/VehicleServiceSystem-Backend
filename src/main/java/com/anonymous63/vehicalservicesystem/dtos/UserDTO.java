package com.anonymous63.vehicalservicesystem.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    @NotEmpty
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String mobileNo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private boolean enabled;
}
