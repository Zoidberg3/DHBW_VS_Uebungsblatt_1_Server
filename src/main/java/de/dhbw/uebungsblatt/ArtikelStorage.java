package de.dhbw.uebungsblatt;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ArtikelStorage extends ConcurrentHashMap<String, Artikel> {
	private ArtikelStorage() {
		this.put("0", new Artikel(0L, "Zahnbürste", 1.98f  ));
		this.put("1", new Artikel(1L, "Klobürste", 2.98f  ));
		this.put("2", new Artikel(2L, "Haarbürste", 2.49f  ));
		this.put("3", new Artikel(3L, "Kamm", 1.49f  ));
	}
}
