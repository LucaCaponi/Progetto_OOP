package ProgettoOOP.app.exception;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         Eccezione lanciata se il paese che si vuole inserire è già presente
 *         nella lista definita dall'utente.
 * 
 */

public class ExistingISO2 extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare.
	 *
	 * @return String.
	 */

	@Override
	public String getMessage() {
		return "Existing ISO2!";
	}

}
