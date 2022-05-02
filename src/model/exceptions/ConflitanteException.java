package model.exceptions;

public class ConflitanteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConflitanteException(String msg) {
		super(msg);
	}

}