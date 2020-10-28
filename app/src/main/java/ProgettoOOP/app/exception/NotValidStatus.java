package ProgettoOOP.app.exception;

/**
 * 
 * 
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class NotValidStatus extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */

	@Override
	public String getMessage() {
		return "Attenzione: lo status scelto non è disponibile. "
				+ "Gli status possibili sono: 'confirmed', 'deaths', 'recovered' e 'active'.";

	}

}