package de.dhbw.uebungsblatt;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class KundeStorage extends ConcurrentHashMap<String, Kunde> {
	
	private KundeStorage(){
		this.put("0", new Kunde(0L, "Thomas", "Specht", "Paul-Wittsack-Straße", "10", "68163", "Mannheim"));
		this.put("1", new Kunde(1L, "Michael", "Gröschel", "Paul-Wittsack-Straße", "10", "68163", "Mannheim"));
		this.put("2", new Kunde(2L, "Peter", "Müller", "Schwetzinger Straße", "17", "68163", "Mannheim"));
		this.put("3", new Kunde(3L, "Peter", "Kaiser", "Bismarckstraße", "32", "68234", "Heidelberg"));
	}
}
