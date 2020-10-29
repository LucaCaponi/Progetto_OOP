package ProgettoOOP.app.stats;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe StatsModel serve da modello per le statistiche sul numero
 *         di contagi giornalieri e sulle loro variazioni percentuali.
 * 
 */

public class StatsModel {
	private String Date;
	private long DailyConfirmed;
	private String Var;

	public StatsModel(String date, long dailyConfirmed, String var) {
		Date = date;
		DailyConfirmed = dailyConfirmed;
		Var = var;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public long getDailyConfirmed() {
		return DailyConfirmed;
	}

	public void setDailyConfirmed(long dailyConfirmed) {
		DailyConfirmed = dailyConfirmed;
	}

	public String getVar() {
		return Var;
	}

	public void setVar(String var) {
		Var = var;
	}

}
