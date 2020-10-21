package ProgettoOOP.app.model;

public class Confirmed extends Countries {
	private long SumConfirmed=0;
	
	//Countries c;
	//CountryAllStatus a=new CountryAllStatus(null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
	
	public Confirmed(String name,String slug, String code, long sumConfirmed) {
		super(name,slug,code);
		this.SumConfirmed=sumConfirmed;
	}

	
	public long getSumConfirmed() {
		return SumConfirmed;
	}

	public void setSumConfirmed(long sumConfirmed) {
		SumConfirmed = sumConfirmed;
	}

	
	public static long sum(long a) {
		long s=0;	
		s+=a;
		return s;
	}
}
