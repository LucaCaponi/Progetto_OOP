package ProgettoOOP.app.model;

public class Linking {
private static String NameCountry;
private static String ISOcode;
private static int SumConfirmed=0;

public Linking(String nameCountry, String iSOcode, int sumConfirmed ) {
NameCountry= nameCountry;
ISOcode= iSOcode;
SumConfirmed= sumConfirmed;
	
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


public static void controlClassify(Countries controlcountry, CountryAllStatus controlall) {

if(controlcountry.getCountry().equals(controlall.getCountry())==true && 
controlcountry.getISO2().equals(controlall.getCountryCode() )==true) {
createObject(controlcountry, controlall);	
}
}

public static void createObject(Countries createcountry,CountryAllStatus createall) {	
NameCountry=createcountry.getCountry();
ISOcode=createcountry.getISO2();
SumConfirmed=sum(createall.getConfirmed());

//Country
//ISO2
//SumConfirmed
}

public static int sum(int a) {
int s=0;	
s+=a;
return s;
}
}
/*
Se il controlClassify restituisce true, voglio che, a mo di lista, mi venga caricato un elemento con 
nome del country
codice del country
numero di contagi (quale giorno?)
Devo caricare come fosse un JSONObject? 
/*
 COUNTRY
 CODICE
 CONTAGI
 */

 