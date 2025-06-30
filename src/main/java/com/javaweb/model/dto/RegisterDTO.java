package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO extends AbstractDTO{
    private String userName;
    private String fullName;
    private String password;
    private String confirmPassword;
}
