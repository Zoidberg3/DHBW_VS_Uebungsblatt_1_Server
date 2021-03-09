package de.dhbw.uebungsblatt;

public class Bestellung {
	public Long bestellungsNr;
	public Long kundenNr;
	public Bestellung(){
	
	}

	public Bestellung (Long bestellungsNr, Long kundenNr){
		this.bestellungsNr = bestellungsNr;
		this.kundenNr = kundenNr;
	}
	
	
	public String toString() {
		return "Kundennummer: "+ kundenNr+ "Bestellungsnummer: " + bestellungsNr;
	}
}
