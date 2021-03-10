package de.dhbw.uebungsblatt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.*;

@RestController
@RequestMapping("/bestellung")

public class BestellungController {
	private BestellungStorage Bestellung;
	
	@Autowired
	BestellungController(BestellungStorage BestellungStorage){
		this.Bestellung = BestellungStorage;
	}
	
	
	@GetMapping(path ="/{id}")
	public Bestellung get(@PathVariable String id ){
		return Bestellung.get(id);
	}
	
	@GetMapping
	public Collection<Bestellung>find(
			@RequestParam(required = false) Long bestellungsNr,
			@RequestParam(required = false) Long kundenNr) {
		Collection<Bestellung> BestellungCollection = Bestellung.values();
		Stream<Bestellung> stream = BestellungCollection.stream();
		if(bestellungsNr != null){
			stream = stream.filter(Bestellung -> Bestellung.bestellungsNr.equals(bestellungsNr));
		}
		if(kundenNr != null){
			stream = stream.filter(Bestellung -> Bestellung.kundenNr.equals(kundenNr));
		}
		return stream.collect(Collectors.toList());
		
	}
	@PostMapping
	public Bestellung post(@RequestBody Bestellung bestellung) {
		Bestellung.put(Long.toString(bestellung.bestellungsNr), bestellung);
		return bestellung;
	}
	
	@PutMapping(path ="/{id}")
	public Bestellung put(@PathVariable String id, @RequestBody Bestellung bestellung){
		Bestellung bes = Bestellung.get(id);
		if (bes != null) {
			if (bestellung.bestellungsNr != null)
				bes.bestellungsNr = bestellung.bestellungsNr;
			if (bestellung.kundenNr != null)
				bes.kundenNr = bestellung.kundenNr;
			return bes;
		}
		else{
			this.Bestellung.put(Long.toString(bestellung.bestellungsNr), bestellung);
			return bestellung;
		}
	}
	
	@DeleteMapping(path ="/{id}")
	public void delete(@PathVariable String id){
		Bestellung.remove(id);
	}
}
