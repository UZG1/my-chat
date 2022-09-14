package com.vladyslavmelnikov.mychat.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class User {

    private String name;

    public enum LoginStatus {
        LOGIN,
        LOGOUT
    }

    LoginStatus loginStatus = LoginStatus.LOGIN;
}
