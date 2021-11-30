package com.company;

public class RideNotFoundException extends Exception {
    /** Creates an RideNotFoundException with a given message
     * @param errorMessage Given message for the exception*/
    public RideNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
