package com.maveric.authenticationauthorizationservice.constants;

import java.time.LocalDateTime;


public class Constants {

    private Constants() {
    }

    public static final String METHOD_NOT_ALLOWED_CODE="405";
    public static final String METHOD_NOT_ALLOWED_MESSAGE="Method Not Allowed. Kindly check the Request URL and Request Type.";
    public static final String BAD_REQUEST_CODE="400";
    public static final String BAD_REQUEST_MESSAGE="Invalid inputs!";
    public static final String NOT_AUTHORIZED_CODE="401";
    public static final String NOT_AUTHORIZED_MESSAGE="Invalid Credentials, Kindly check your EmailId or Password!";
    public static final String USER_NOT_FOUND_CODE="404";
    public static final String USER_NOT_FOUND_MESSAGE="User not found! Kindly signup for our bank.";
    public static final String ACCOUNT_CREATION_FAILED_CODE="500";
    public static final String ACCOUNT_CREATION_FAILED_MESSAGE="Account creation failed! Kindly contact administrator.";
    public static final String INCORRECT_URL_CODE="404";
    public static final String INCORRECT_URL_MESSAGE="The server can not find the requested resource.";
}