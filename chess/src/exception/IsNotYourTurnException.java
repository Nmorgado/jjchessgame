package exception;

public class IsNotYourTurnException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972762222201540487L;

	public IsNotYourTurnException() {
		super("N�o � sua Vez de jogar!");
	}
}
