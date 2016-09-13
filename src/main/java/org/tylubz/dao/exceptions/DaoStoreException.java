package org.tylubz.dao.exceptions;

/**
 * Created by Sergei on 13.09.2016.
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
