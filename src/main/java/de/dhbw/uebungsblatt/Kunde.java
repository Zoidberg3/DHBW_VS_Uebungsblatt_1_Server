package de.dhbw.uebungsblatt;

public class Kunde {
	public Long kundenNr;
	public String vorname;
	public String nachname;
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public Kunde(){
	
	}

	public Kunde (Long kundenNr, String vorname, String nachname, String strasse, String hausnummer, String plz, String ort){
		this.kundenNr = kundenNr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}
	
	public String toString() {return kundenNr + " " + vorname+ " " + nachname+ " " + strasse + " " + " " + hausnummer+ " " +" " + plz+ " " + " " + ort;
	}
}
