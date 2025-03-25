package com.bootReact.Spring_Boot_and_React_CRUD_Operation.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
                    super("this "+id+" is not available");
    }
}
