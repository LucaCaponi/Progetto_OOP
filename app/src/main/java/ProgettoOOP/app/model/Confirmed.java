package ProgettoOOP.app.model;

public class Confirmed {
	private String NameCountry;
	private String ISOcode;
	private int SumConfirmed=0;
	
	public Confirmed(String nameCountry, String iSOcode, int sumConfirmed) {	
		this.NameCountry=nameCountry;
		this.ISOcode=iSOcode;
		this.SumConfirmed=sumConfirmed;
	}

	public String getNameCountry() {
		return NameCountry;
	}

	public void setNameCountry(String nameCountry) {
	NameCountry = nameCountry;
	}

	public String getISOcode() {
		return ISOcode;
	}

	public void setISOcode(String iSOcode) {
		ISOcode = iSOcode;
	}

	public int getSumConfirmed() {
		return SumConfirmed;
	}

	public void setSumConfirmed(int sumConfirmed) {
		SumConfirmed = sumConfirmed;
	}

	public static int sum(int a) {
		int s=0;	
		s+=a;
		return s;
	}
}
