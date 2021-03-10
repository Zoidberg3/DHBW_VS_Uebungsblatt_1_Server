package de.dhbw.uebungsblatt;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ArtikelStorage extends ConcurrentHashMap<Long, Artikel> {
	private ArtikelStorage() {
		this.put(0L, new Artikel(0L, "Zahnbürste", 1.98f  ));
		this.put(1L, new Artikel(1L, "Klobürste", 2.98f  ));
	}
}
