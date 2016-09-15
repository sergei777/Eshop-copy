package org.tylubz.dao.exceptions;

/**
 * Exception class for Dao layer.
 */
public class DaoStoreException extends Exception {
    public DaoStoreException() {
        super();
    }

    public DaoStoreException(String message) {
        super(message);
    }

    public DaoStoreException(Throwable cause) {
        super(cause);
    }

    public DaoStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
