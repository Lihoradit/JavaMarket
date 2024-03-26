package org.example.Exceptions;

public class LowBalanceException extends Exception{
    public LowBalanceException(String e) {
        System.out.println(e);
    }
}
