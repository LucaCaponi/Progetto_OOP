package ProgettoOOP.app.exception;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         Classe astratta da cui ereditano le eccezioni del progetto.
 * 
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
