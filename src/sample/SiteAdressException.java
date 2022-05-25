package sample;

public class SiteAdressException extends Exception {
    public SiteAdressException() {
        super();
    }

    public SiteAdressException(String message) {
        super(message);
    }

    public SiteAdressException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteAdressException(Throwable cause) {
        super(cause);
    }

    public SiteAdressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
