package de.dhbw.uebungsblatt;

public class Bestellposition {
	public Long bestellposNr;
	public Long bestellungsNr;
	public String artikelNr;
	public String anzahl;
	public Bestellposition(){
	
	}
	
	public Bestellposition(Long bestellposNr, Long bestellungsNr, String artikelNr, String anzahl){
		this.bestellposNr = bestellposNr;
		this.bestellungsNr = bestellungsNr;
		this.artikelNr = artikelNr;
		this.anzahl = anzahl;
	}
	public String toString(){
		return "Bestellposition: " + bestellposNr + "Bestellungsnr. "+ bestellungsNr + "Artiekelnummer: " + artikelNr + "Anzahl: " + anzahl;
	}
}
