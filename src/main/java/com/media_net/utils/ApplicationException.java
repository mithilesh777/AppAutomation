package com.media_net.utils;

/**
 * @author mithilesh.singh
 * This is coustmised exception clss, we can create our own exception and throw.
 * Just a sample to provide overview how can we achieve it.
 */


public class ApplicationException extends Exception {

    String message;
    String methodName;

    public String getMessageName() {
        return this.message;
    }

    public void setMessageName(String messageName) {
        this.message = messageName;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ApplicationException() {
    }

    public ApplicationException(String methodName, String message) {
        super(message);
        this.methodName = methodName;
        this.message = message;
    }
}