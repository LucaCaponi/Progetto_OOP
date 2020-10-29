package ProgettoOOP.app.exception;

/**
 * 
 * 
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class NotValidThreshold extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */

	@Override
	public String getMessage() {
		return "Attenzione: la soglia scelta non è disponibile. " +
			   "Le soglie possibili sono '$gt' (>) e '$lt' (<)";

	}
	
}
