package de.dhbw.uebungsblatt;

public class Artikel {
	public  Long artikelNr;
	public String bezeichnung;
	public Float einzelpreis;
	public Artikel(){
	
	}
	//@Autowired
	public Artikel(Long artikelNr, String bezeichnung, Float einzelpreis){
		this.artikelNr = artikelNr;
		this.bezeichnung = bezeichnung;
		this.einzelpreis = einzelpreis;
	}
	
	
	public String toString() {
		return artikelNr+ " | " + bezeichnung+ " (" + einzelpreis+ ")";
	}
	
}
