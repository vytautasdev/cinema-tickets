package uk.gov.dwp.uc.pairtest.exception;

import java.io.Serial;

public class InvalidPurchaseException extends RuntimeException {

    /*
    RuntimeException extends Exception --->
    Exception extends Throwable --->
    Throwable implements Serializable so InvalidPurchaseException is Serializable too
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidPurchaseException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
