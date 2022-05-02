package model.exceptions;

public class InvalidCharException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCharException(String msg) {
		super(msg);
	}
}
