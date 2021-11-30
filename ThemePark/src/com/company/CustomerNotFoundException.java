package com.company;

public class CustomerNotFoundException extends Exception {
    /** Creates an CustomerNotFoundException with a given message
     * @param errorMessage Given message for the exception*/
    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
