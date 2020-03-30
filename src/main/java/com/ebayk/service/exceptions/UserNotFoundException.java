package com.ebayk.service.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Integer userId) {
        super("User with id '" + userId  + "' does not exist");
    }
}
