package de.dhbw.uebungsblatt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.*;

@RestController
@RequestMapping("/Artikel")
public class ArtikelController {
	
	private ArtikelStorage Artikel;
	
	@Autowired
	ArtikelController(ArtikelStorage ArtikelStorage){
		this.Artikel = ArtikelStorage;
	}
	
	
	@GetMapping(path ="{/artikelNr}")
	public Artikel get(@PathVariable Long artikelNr ){
		return Artikel.get(artikelNr);
	}
	
	@GetMapping
	public Collection<Artikel>find(
			@RequestParam(required = false) Long artikelNr,
			@RequestParam(required = false) String bezeichnung,
			@RequestParam(required = false) Float einzelpreis) {
		Collection<Artikel> ArtikelCollection = Artikel.values();
		Stream<Artikel> stream = ArtikelCollection.stream();
		if(artikelNr != null){
			stream = stream.filter(Artikel -> Artikel.artikelNr.equals(artikelNr));
		}
		if(bezeichnung != null){
			stream = stream.filter(Artikel -> Artikel.bezeichnung.equals(bezeichnung));
		}
		if(einzelpreis != null){
			stream = stream.filter(Artikel -> Artikel.einzelpreis.equals(einzelpreis));
		}
		return stream.collect(Collectors.toList());
		
	}
	@PostMapping
	public Artikel post(@RequestBody Artikel artikel) {
		Artikel.put(String.valueOf(artikel.artikelNr), artikel);
		return artikel;
	}
	
	@PutMapping(path ="{/artikelNr}")
	public Artikel put(@PathVariable Long artikelNr, @RequestBody Artikel artikel){
		Artikel art = Artikel.get(artikelNr);
		if (art != null) {
			if (artikel.artikelNr != null)
				art.artikelNr = artikel.artikelNr;
			if (artikel.bezeichnung != null)
				art.bezeichnung = artikel.bezeichnung;
			if (artikel.einzelpreis != null)
				art.einzelpreis = artikel.einzelpreis;
			return art;
		}
		else{
			this.Artikel.put(String.valueOf(artikel.artikelNr), artikel);
			return artikel;
		}
	}
	
	@DeleteMapping(path ="{/artikelNr}")
	public void delete(@PathVariable Long artikelNr){
		Artikel.remove(artikelNr);
	}
}


