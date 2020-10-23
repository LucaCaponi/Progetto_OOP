package ProgettoOOP.app.exception;


	/**
	 * 
	 * Eccezione lanciata se il il continente che si vuole inserire non è corretto o non esiste
	 * 
	 * 
	 * @author Federico Catalini
	 * @author Luca Caponi
	 */

	public class NotValidContinent extends ExceptionAbstract {
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * Ottiene il messaggio da stampare
		 *
		 * @return String
		 */
		
		@Override
		public String getMessage() {
			return "Continente errato!";
		}

	}


