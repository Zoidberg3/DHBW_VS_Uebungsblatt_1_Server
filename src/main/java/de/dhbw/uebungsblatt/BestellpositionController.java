package de.dhbw.uebungsblatt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.*;

@RestController
@RequestMapping("/bestellposition")
public class BestellpositionController {
	
	private BestellpositionStorage Bestellpositionen;
	
	@Autowired
	BestellpositionController(BestellpositionStorage BestellpositionStorage){
		this.Bestellpositionen = BestellpositionStorage;
	}
	
	 
	@GetMapping(path ="/{id}")
	public Bestellposition get(@PathVariable String id ){
		return Bestellpositionen.get(id);
	}
	
	@GetMapping
	public Collection<Bestellposition>find(
			@RequestParam(required = false) Long bestellposNr,
			@RequestParam(required = false) Long bestellungsNr,
			@RequestParam(required = false) String artikelNr,
			@RequestParam(required = false) String anzahl) {
		Collection<Bestellposition> BestellpositionenCollection = Bestellpositionen.values();
		Stream<Bestellposition> stream = BestellpositionenCollection.stream();
		if(bestellposNr != null){
			stream = stream.filter(bestellposition -> bestellposition.bestellposNr.equals(bestellposNr));
		}
		if(bestellungsNr != null){
			stream = stream.filter(bestellposition -> bestellposition.bestellungsNr.equals(bestellungsNr));
		}
		if(artikelNr != null){
			stream = stream.filter(bestellposition -> bestellposition.artikelNr.equals(artikelNr));
		}
		if(anzahl!= null){
			stream = stream.filter(bestellposition -> bestellposition.anzahl.equals(anzahl));
		}
		return stream.collect(Collectors.toList());
		
	}
	@PostMapping
	public Bestellposition post(@RequestBody Bestellposition bestellposition) {
		Bestellpositionen.put(Long.toString(bestellposition.bestellposNr), bestellposition);
		return bestellposition;
	}
	
	@PutMapping(path ="/{id}")
	public Bestellposition put(@PathVariable String id, @RequestBody Bestellposition bestellposition){
		Bestellposition best = Bestellpositionen.get(id);
		if (best != null) {
			if (bestellposition.bestellposNr != null)
				best.bestellposNr = bestellposition.bestellposNr;
			if (bestellposition.bestellungsNr != null)
				best.bestellungsNr = bestellposition.bestellungsNr;
			if (bestellposition.artikelNr != null)
				best.artikelNr = bestellposition.artikelNr;
			if (bestellposition.anzahl != null)
				best.anzahl = bestellposition.anzahl;
			return best;
		}
		else{
			this.Bestellpositionen.put(Long.toString(bestellposition.bestellposNr), bestellposition);
			return bestellposition;
		}
	}
	
	@DeleteMapping(path ="/{id}")
	public void delete(@PathVariable String id){
		Bestellpositionen.remove(id);
	}
}
