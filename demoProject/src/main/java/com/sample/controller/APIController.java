package com.sample.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
import com.sample.model.KSessionModel;
import com.sample.model.Obelezje;
import com.sample.model.PodaciODelu;
import com.sample.model.QueryDataList;
import com.sample.model.TipTuzioca;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.ObelezjeService;
import com.sample.service.TuzilacService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
@RequestMapping(value = "data")
public class APIController {
	
	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;
	
	@Autowired
	DokazService dokazService;
	
	@Autowired
	TuzilacService tuzilacService;

	
	@RequestMapping(value = "/sendData", method = RequestMethod.POST)
	public ResponseEntity<String> sendData(HttpEntity<String> json) throws ParseException{

		String jString = json.getBody();
		System.out.println(jString);
		QueryDataList.getInstance().clear();
		
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		JSONArray jArrAge1 = (JSONArray) jObj.get("starost1");
		JSONArray jArrAge2 = (JSONArray) jObj.get("starost2");
		JSONArray jArrSubOdnos = (JSONArray) jObj.get("subOdnos");
		JSONArray jArrMesto = (JSONArray) jObj.get("mesto");
		JSONArray jArrRadnja = (JSONArray) jObj.get("radnja");
		JSONArray jArrStanje = (JSONArray) jObj.get("stanje");
		JSONArray jArrBroj = (JSONArray) jObj.get("broj");
		JSONArray jArrStatus = (JSONArray) jObj.get("status");
		JSONArray jArrPsih = (JSONArray) jObj.get("psih");
	
		String age1 = null;
		String age2 = null;
		String subOdnos = null;
		String mesto = null;
		String stanje = null;
		String broj = null;
		String radnja = null;
		String status = null;
		String psih = null;
		
		for(Object o : jArrAge1) {
			if(age1 == null) {
				age1 = o.toString();
			}else{
				age1 += "&";
				age1 += o.toString();
			}
		}
		
		for(Object o : jArrAge2) {
			if(age2 == null) {
				age2 = o.toString();
			}else{
				age2 += "&";
				age2 += o.toString();
			}
		}
		
		for(Object o : jArrSubOdnos) {
			if(subOdnos == null) {
				subOdnos = o.toString();
			}else{
				subOdnos += "&";
				subOdnos += o.toString();
			}
		}
		
		for(Object o : jArrMesto) {
			if(mesto == null) {
				mesto = o.toString();
			}else{
				mesto += "&";
				mesto += o.toString();
			}
		}
		
		for(Object o : jArrRadnja) {
			if(radnja == null) {
				radnja = o.toString();
			}else{
				radnja += "&";
				radnja += o.toString();
			}
		}
		
		for(Object o : jArrStanje) {
			if(stanje == null) {
				stanje = o.toString();
			}else{
				stanje += "&";
				stanje += o.toString();
			}
		}
		
		for(Object o : jArrBroj) {
			if(broj == null) {
				broj = o.toString();
			}else{
				broj += "&";
				broj += o.toString();
			}
		}
		
		for(Object o : jArrStatus) {
			if(status == null){
				status = o.toString();
			}else {
				status += "&";
				status += o.toString();
			}
		}
		
		for(Object o : jArrPsih) {
			if(psih == null) {
				psih = o.toString();
			}else {
				psih += "&";
				psih += o.toString();
			}
		}
		
		if(age1 != null && !age1.equals("nema podataka")) {
			QueryDataList.getInstance().put("age1", age1);
		}
		
		if(age2 != null && !age2.equals("nema podataka")) {
			QueryDataList.getInstance().put("age2", age2);
		}
		
		if(subOdnos != null && !subOdnos.equals("nema podataka")) {
			QueryDataList.getInstance().put("subOdnos", subOdnos);
		}
		
		if(mesto != null && !mesto.equals("nema podataka")) {
			QueryDataList.getInstance().put("mesto", mesto);
		}
		
		if(radnja != null && !radnja.equals("nema podataka")) {
			QueryDataList.getInstance().put("radnja", radnja);
		}
		
		if(stanje != null && !stanje.equals("nema podataka")) {
			QueryDataList.getInstance().put("stanje", stanje);
		}
		
		if(broj != null && !broj.equals("nema podataka")) {
			QueryDataList.getInstance().put("broj", broj);
		}
		
		if(status != null && !status.equals("nema podataka")) {
			QueryDataList.getInstance().put("zrtva", "poseban status");
		}
		
		if(psih != null && !psih.equals("nema podataka")){
			QueryDataList.getInstance().put("izvrsilacStanje", "doveden u posebno psihicko stanje");
		}
		else {
			QueryDataList.getInstance().put("izvrsilacStanje", "nema podataka");
		}
		
		System.out.println(QueryDataList.getInstance().get("izvrsilacStanje").toString());
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("ksession-rules");
 		
 		//QueryDataList qdl = QueryDataList.getInstance();
        kSession.insert(QueryDataList.getInstance());
        KSessionModel.getInstance().createDRL();
    	KSessionModel.getInstance().getkSession().insert(QueryDataList.getInstance());
    	List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja) {
			KSessionModel.getInstance().getkSession().insert(o);
			kSession.insert(o);
		}
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela) {
			KSessionModel.getInstance().getkSession().insert(d);
			kSession.insert(d);
		}
		
		List<Dokaz> dokazi = dokazService.findAll();
		for(Dokaz d : dokazi) {
			KSessionModel.getInstance().getkSession().insert(d);
			kSession.insert(d);
		}
		
		List<Tuzilac> tuzioci = tuzilacService.findAll();
 		for(Tuzilac t : tuzioci) {
 			KSessionModel.getInstance().getkSession().insert(t);
 			kSession.insert(t);
 		}
		
		int templateFired = KSessionModel.getInstance().getkSession().fireAllRules();
		System.out.println("##" + templateFired);
		Collection<KiePackage> packagess = KSessionModel.getInstance().getkSession().getKieBase().getKiePackages();
		int rule = 0;
		for(KiePackage p : packagess) {
			rule += p.getRules().size();
		}
		System.out.println("Num: " + rule);
		
		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> pod = (Collection<PodaciODelu>) KSessionModel.getInstance().getkSession().getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu1 = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : pod) {
			podaciODelu1.add(p);
			kSession.insert(p);
		}
		System.out.println("###" + pod.size());
        
        
        System.out.println(QueryDataList.getInstance().toString());
		
        int fired = kSession.fireAllRules();
 		System.out.println("##" + fired);
 		Collection<KiePackage> packages = kSession.getKieBase().getKiePackages();
 		int rules = 0;
 		for(KiePackage p : packages) {
 			rules += p.getRules().size();
 		}
 		System.out.println("Num: " + rules);
		
 		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		String odgovor = "";
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);
		
		if(podaciODelu.size() >= 1) {
			PodaciODelu p = podaciODelu.get(podaciODelu.size() - 1);
			odgovor += "Za ovo krivično delo neophodno je pozvati ";
			if (p.getTuzilac().getTip().equals(TipTuzioca.OSNOVNI_JAVNI_TUZILAC)) {
				odgovor += "osnovnog javnog tužioca";
			} else if (p.getTuzilac().getTip().equals(TipTuzioca.VISI_JAVNI_TUZILAC)) {
				odgovor += "višeg javnog tužioca";
			} else if (p.getTuzilac().getTip().equals(TipTuzioca.TUZILAC_ZA_MALOLETNIKE)) {
				odgovor += "tužioca za maloletnike";
			} else if (p.getTuzilac().getTip().equals(TipTuzioca.TUZILAC_ZA_ORGANIZOVANI_KRIMINAL)) {
				odgovor += "tužioca za organizovani kriminal";
			} else if (p.getTuzilac().getTip().equals(TipTuzioca.TUZILAC_ZA_RATNE_ZLOCINE)) {
				odgovor += "tužioca za ratne zlocine";
			}
			odgovor += ".&";
			odgovor += "Neophodno je prikupiti sledeće dokaze: ";
			for (Dokaz d : p.getDokazi()) {
				odgovor += d.getOpis();
				odgovor += " ";
			}
			odgovor += ".&";
			odgovor += "U pitanju je krivično delo sa nazivom: \"" + p.getDelo().getNaziv() + "\"";
			odgovor += ".&";
			odgovor += "Predviđena je maksimalna kazna do: " + p.getDelo().getMaxKazna() + " godina zatvora.";
		}
	
		return new ResponseEntity<String>(odgovor, HttpStatus.OK);
	}
	
}
