package ProgettoOOP.app.stats;

public class Stats {
	private String Date;
	private long DailyConfirmed;
	private String Var;
	
	
	public Stats(String date, long dailyConfirmed, String var) {
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
