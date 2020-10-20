package ProgettoOOP.app.model;

public class Confirmed extends Countries{
	private int SumConfirmed=0;
	
	//Countries c;
	//CountryAllStatus a=new CountryAllStatus(null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
	
	public Confirmed(String name,String slug, String code, int SumConfirmed) {
		super(name,slug,code);
		this.SumConfirmed=SumConfirmed;
	}

	
	public int getSumConfirmed() {
		return SumConfirmed;
	}

	public void setSumConfirmed(int number) {
		SumConfirmed = number;
	}

	
	public static int sum(int a) {
		int s=0;	
		s+=a;
		return s;
	}
}
