package exception;

public class InvalidMovementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7215721451194517311L;

	public InvalidMovementException() {
		super("Movimento inv�lido");
	}

	/**
	 * 
	 * @param cause
	 *            - a causa domovimento inv�lido
	 */
	public InvalidMovementException(String cause) {
		super("Movimento inv�lido - " + cause);
	}
}
