package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
import com.sample.model.Obelezje;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.ObelezjeService;
import com.sample.service.TuzilacService;

@RestController
@RequestMapping(value = "/list")
public class ListController {

	@Autowired
	private TuzilacService tuzilacService;
	
	@Autowired
	private DeloService deloService;
	
	@Autowired
	private DokazService dokazService;
	
	@Autowired
	private ObelezjeService obelezjeService;
	
	@GetMapping(value = "/tuzioci")
	public List<Tuzilac> getTuzioci() {
		return tuzilacService.findAll();
	}
	
	@GetMapping(value = "/dela")
	public List<Delo> getDela() {
		List<Delo> svaDela = deloService.findAll();
		List<Delo> povratna = new ArrayList<Delo>();
		for (Delo delo : svaDela) {
			boolean found = false;
			for (Delo d : povratna) {
				if (delo.getNaziv().equals(d.getNaziv()))
					found = true;
			}
			if (!found)
				povratna.add(delo);
		}
		return povratna;
	}
	
	@GetMapping(value = "/dokazi")
	public List<Dokaz> getDokazi() {
		return dokazService.findAll();
	}
	
	@GetMapping(value = "/sendTuzilac/{response}")
	public ResponseEntity<String> sendTuzioci(@PathVariable("response") String response) {
		if (!response.contains("&"))
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		String[] splitter = response.split("&");
		System.out.println(splitter[0]);
		// TODO odraditi dalje islistavanje tuzioca i potrebnih detalja
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@GetMapping(value = "/sendDokazi/{response}")
	public ResponseEntity<String> sendDokazi(@PathVariable("response") String response) {
		
		response += "."; // Iz nekog razloga na poslednji selektovan dokaz ne stavi tacku na kraju
		if (!response.contains("&"))
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		String[] splitter = response.split("&");
		
		// TODO odraditi dalje islistavanje dokaza i potrebnih detalja
		
		String odgovor = "";
		for(int i = 1; i < splitter.length; i++) {
			System.out.println(splitter[i]);
			odgovor += "Dela koja su vezana za dokaz \"" + splitter[i] + "\" su: ";
			
			KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
			KieSession kSession = kc.newKieSession("ksession-rules");
			
			List<Delo> dela = deloService.findAll();
			
			for(Delo d:dela) {
				kSession.insert(d);
			}
			
			List<Obelezje> obelezja = obelezjeService.findAll();
			
			for(Obelezje o:obelezja) {
				kSession.insert(o);
			}
			
			QueryResults results = kSession.getQueryResults(splitter[i]);
			System.out.println( "BROJ ODGOVORA JE: " + results.size() );
			
			
			String odg = "";
			for ( QueryResultsRow row : results ) {
			    Delo delo = ( Delo ) row.get( "$delo" );
			    if (!odg.contains(delo.getNaziv().toUpperCase()))
			    	odg += delo.getNaziv().toUpperCase() + ", ";
			}
			
			odgovor += odg.substring(0, odg.length() - 2);
			if (i < splitter.length - 1)
				odgovor += "&";
			
		}
		System.out.println(odgovor);
		
		return new ResponseEntity<String>(odgovor, HttpStatus.OK);
	}
	
	@GetMapping(value = "/sendDela/{response}")
	public ResponseEntity<String> sendDela(@PathVariable("response") String response) {
		if (!response.contains("&"))
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		String[] splitter = response.split("&");
		System.out.println(splitter[0]);
		// TODO odraditi dalje islistavanje dela i potrebnih detalja
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
}
