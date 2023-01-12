package Utilidades;

public class UtilExceptions extends Exception{
	public UtilExceptions(String message) {
		super(message);
	}

	public UtilExceptions(Throwable cause) {
		super(cause);
	}

	public UtilExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
