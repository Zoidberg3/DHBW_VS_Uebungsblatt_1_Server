package de.dhbw.uebungsblatt;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class BestellungStorage extends ConcurrentHashMap<String, Bestellung> {
	
	private BestellungStorage(){
		this.put("0", new Bestellung(0L, 2L));
		this.put("1", new Bestellung(1L, 2L));
		this.put("2", new Bestellung(2L, 1L));
		this.put("3", new Bestellung(3L, 3L));
	}
}
