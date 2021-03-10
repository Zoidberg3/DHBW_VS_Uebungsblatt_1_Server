package de.dhbw.uebungsblatt;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class BestellpositionStorage extends ConcurrentHashMap<String, Bestellposition> {
	
	private BestellpositionStorage(){
		this.put("0", new Bestellposition(0L, 0L, "3", "1"));
		this.put("1", new Bestellposition(1L, 0L, "2", "4"));
		this.put("2", new Bestellposition(2L, 1L, "0", "1"));
		this.put("3", new Bestellposition(3L, 2L, "2", "1"));
		this.put("4", new Bestellposition(4L, 3L, "2", "2"));
		this.put("5", new Bestellposition(5L, 4L, "3", "5"));
	}
}
