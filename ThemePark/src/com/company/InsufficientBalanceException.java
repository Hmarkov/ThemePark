package com.company;

public class InsufficientBalanceException extends Exception {
    /** Creates an InsufficientBalanceException with a given message
     * @param errorMessage Given message for the exception*/
    public InsufficientBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
