package com.sample.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Delo;
import com.sample.model.DokazRoot;
import com.sample.model.LinkD;
import com.sample.model.LinkDAnswer;
import com.sample.model.LinkT;
import com.sample.model.LinkTAnswer;
import com.sample.model.QueryDataList;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazRootService;
import com.sample.service.LinkDService;
import com.sample.service.LinkTService;
import com.sample.service.TuzilacService;

@RestController
@RequestMapping(value = "/list")
public class ListController {

	@Autowired
	private TuzilacService tuzilacService;
	
	@Autowired
	private DeloService deloService;
	
	@Autowired
	private DokazRootService dokazService;
	
	@Autowired
	private LinkTService linkTService;
	
	@Autowired
	private LinkDService linkDService;
	
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
	public List<DokazRoot> getDokazi() {
		return dokazService.findAll();
	}
	
	@GetMapping(value = "/sendTuzilac/{response}")
	public ResponseEntity<String> sendTuzioci(@PathVariable("response") String response) {
		if (!response.contains("&"))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		String[] splitter = response.split("&");

		String odgovor = "";
        for(int i = 1; i < splitter.length; i++) {
			KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieSession kSession =  kContainer.newKieSession("ksession-rules");
			
	        List<LinkT> tuziociLink = linkTService.findAll();
	        
	        for(LinkT t : tuziociLink)
	        	kSession.insert(t);
	        
	        List<LinkD> dokazLink = linkDService.findAll();
	        
	        for(LinkD d : dokazLink)
	        	kSession.insert(d);
	        
	        odgovor += "Dela koja pripadaju pod nadležnost tužioca pod nazivom " + splitter[i] + " su: ";
	        QueryDataList.getInstance().put("tuzilac", splitter[i]);
	        System.out.println(QueryDataList.getInstance().toString());
	        kSession.insert(QueryDataList.getInstance());
	        int fired = kSession.fireAllRules();
	        
	        System.out.println("Fired " + fired);
	    	@SuppressWarnings("unchecked")
	    	Collection<LinkTAnswer> dela = (Collection<LinkTAnswer>) kSession.getObjects(new ClassObjectFilter(LinkTAnswer.class));
	    	
	    	String odg = "";
	        for(LinkTAnswer t : dela) {
	        	Delo novoDelo = deloService.findByClanTackaStav(t.getClan(),t.getStav(),t.getTacka());
	        	if (!odg.contains(novoDelo.getNaziv().toUpperCase()))
			    	odg += novoDelo.getNaziv().toUpperCase() + ", ";
	        	
	        }
	        
	        //odgovor += odg.substring(0, odg.length() - 2);
			if (i < splitter.length - 1)
				odgovor += "&";
	        
        }
        
        System.out.println("ODGOVOR: " + odgovor);
    	return new ResponseEntity<String>(odgovor, HttpStatus.OK);

	}
	
	@GetMapping(value = "/sendDokazi/{response}")
	public ResponseEntity<String> sendDokazi(@PathVariable("response") String response) {
		
		response += "."; // Iz nekog razloga na poslednji selektovan dokaz ne stavi tacku na kraju
		if (!response.contains("&"))
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		String[] splitter = response.split("&");
		
		String odgovor = "";
        for(int i = 1; i < splitter.length; i++) {
		
			KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieSession kSession =  kContainer.newKieSession("ksession-rules");
	        
		    List<LinkT> tuziociLink = linkTService.findAll();
		        
	        for(LinkT t : tuziociLink)
	        	kSession.insert(t);
	        
	        List<LinkD> dokazLink = linkDService.findAll();
	        
	        for(LinkD d : dokazLink)
	        	kSession.insert(d);
	        
        
        	odgovor += "Dokaz pod nazivom " + splitter[i] + " je potreban za sledeca dela: ";
        	QueryDataList.getInstance().put("dokaz", splitter[i]);
	        System.out.println(QueryDataList.getInstance().toString());
	        kSession.insert(QueryDataList.getInstance());
	        int fired = kSession.fireAllRules();
	        System.out.println("Fired " + fired);
	        
	        @SuppressWarnings("unchecked")
	    	Collection<LinkDAnswer> dela = (Collection<LinkDAnswer>) kSession.getObjects(new ClassObjectFilter(LinkDAnswer.class));
	        
	        String odg = "";
        	for(LinkDAnswer d:dela) {
	        	Delo novoDelo = deloService.findByClanTackaStav(d.getClan(),d.getStav(),d.getTacka());
	        	if (!odg.contains(novoDelo.getNaziv().toUpperCase()))
			    	odg += novoDelo.getNaziv().toUpperCase() + ", ";
	        	
	        }
        	
        	//odgovor += odg.substring(0, odg.length() - 2);
			if (i < splitter.length - 1)
				odgovor += "&";
	        
        }
        
        System.out.println("ODGOVOR: " + odgovor);
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
