package com.ltnc.JavaApp.Service.AccountService.Exception;

public class UnvalidAccountException extends RuntimeException{
    public UnvalidAccountException(String message){
        super(message);
    }
}
