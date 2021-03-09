package de.dhbw.uebungsblatt;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/Kunde")
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
	//@Autowired
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
