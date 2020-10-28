package ProgettoOOP.app.exception;

/**
 * 
 * Classe astratta da cui ereditano le eccezioni del progetto
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public abstract class ExceptionAbstract extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */

	public abstract String getMessage();
}
