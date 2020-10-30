package ProgettoOOP.app.stats;

/**
 * 
 * La classe StatsModel serve da modello per le statistiche sul numero di
 * contagi giornalieri e sulle loro variazioni percentuali.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */

public class StatsModel {
	private String Date;
	private long DailyConfirmed;
	private String Var;

	/**
	 * 
	 * @param date
	 * @param dailyConfirmed
	 * @param var
	 */
	public StatsModel(String date, long dailyConfirmed, String var) {
		Date = date;
		DailyConfirmed = dailyConfirmed;
		Var = var;
	}

	/**
	 * 
	 * @return
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		Date = date;
	}

	/**
	 * 
	 * @return
	 */
	public long getDailyConfirmed() {
		return DailyConfirmed;
	}

	/**
	 * 
	 * @param dailyConfirmed
	 */
	public void setDailyConfirmed(long dailyConfirmed) {
		DailyConfirmed = dailyConfirmed;
	}

	/**
	 * 
	 * @return
	 */
	public String getVar() {
		return Var;
	}

	/**
	 * 
	 * @param var
	 */
	public void setVar(String var) {
		Var = var;
	}

}
