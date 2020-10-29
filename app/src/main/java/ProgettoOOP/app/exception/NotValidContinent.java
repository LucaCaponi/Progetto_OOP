package ProgettoOOP.app.exception;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         Eccezione lanciata se il continente che si vuole inserire 
 *         non è corretto o non esiste.
 * 
 */

public class NotValidContinent extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare.
	 *
	 * @return String.
	 */

	@Override
	public String getMessage() {
		return "Continente errato!";
	}

}
