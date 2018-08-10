package com.prontoresolved.exceptions;

/**
 * Created by nageshk on 11/9/2017.
 */
public class ProntoResolvedAppNetworkFailureException extends Exception {


    private static final long serialVersionUID = 1L;


    public ProntoResolvedAppNetworkFailureException() {
        super();
    }

    public ProntoResolvedAppNetworkFailureException(String message) {
        super(message);
    }

    public ProntoResolvedAppNetworkFailureException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return null;
    }
}
