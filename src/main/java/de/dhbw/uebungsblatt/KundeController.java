package de.dhbw.uebungsblatt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.*;

@RestController
@RequestMapping("/kunde")
public class KundeController {
	
	private KundeStorage kunden;
	
	@Autowired KundeController(KundeStorage kundeStorage){
		this.kunden = kundeStorage;
	}
	
	
	@GetMapping(path ="/{id}")
	public Kunde get(@PathVariable String id ){
		return kunden.get(id);
	}
	
	@GetMapping
	public Collection<Kunde>find(
			
			@RequestParam(required = false) Long kundenNr,
			@RequestParam(required = false) String vorname,
			@RequestParam(required = false) String nachname,
			@RequestParam(required = false) String strasse,
			@RequestParam(required = false) String hausnummer,
			@RequestParam(required = false) String plz,
			@RequestParam(required = false) String ort) {
		Collection<Kunde> KundeCollection = kunden.values();
		Stream<Kunde> stream = KundeCollection.stream();
		if(kundenNr != null){
			stream = stream.filter(Kunde -> Kunde.kundenNr.equals(kundenNr));
		}
		if(vorname != null){
			stream = stream.filter(Kunde -> Kunde.vorname.equals(vorname));
		}
		if(nachname != null){
			stream = stream.filter(Kunde -> Kunde.nachname.equals(nachname));
		}
		if(strasse != null){
			stream = stream.filter(Kunde -> Kunde.strasse.equals(strasse));
		}
		if(hausnummer != null){
			stream = stream.filter(Kunde -> Kunde.hausnummer.equals(hausnummer));
		}
		if(plz != null){
			stream = stream.filter(Kunde -> Kunde.plz.equals(plz));
		}
		if(ort != null){
			stream = stream.filter(Kunde -> Kunde.ort.equals(ort));
		}
		return stream.collect(Collectors.toList());
		
	}
	@PostMapping
	public Kunde post(@RequestBody Kunde kunde) {
		kunden.put(Long.toString(kunde.kundenNr), kunde);
		return kunde;
	}
	
	@PutMapping(path ="/{id}")
	public Kunde put(@PathVariable String id, @RequestBody Kunde kunde){
		Kunde kund = kunden.get(id);
		if (kund != null) {
			if (kunde.kundenNr != null)
				kund.kundenNr = kunde.kundenNr;
			if (kunde.vorname != null)
				kund.vorname = kunde.vorname;
			if (kunde.nachname != null)
				kund.nachname = kunde.nachname;
			if (kunde.strasse != null)
				kund.strasse = kunde.strasse;
			if (kunde.hausnummer != null)
				kund.hausnummer = kunde.hausnummer;
			if (kunde.plz != null)
				kund.plz = kunde.plz;
			if (kunde.ort != null)
				kund.ort = kunde.ort;
			return kund;
		}
		else{
			this.kunden.put(id, kunde);
			return kunde;
		}
	}
	
	@DeleteMapping(path ="/{id}")
	public void delete(@PathVariable String id){
		kunden.remove(id);
	}
}