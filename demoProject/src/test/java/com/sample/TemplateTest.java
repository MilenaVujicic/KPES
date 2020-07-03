package com.sample;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
import com.sample.model.KSessionModel;
import com.sample.model.NovoDelo;
import com.sample.model.Obelezje;
import com.sample.model.PodaciODelu;
import com.sample.model.QueryDataList;
import com.sample.model.TipTuzioca;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.ObelezjeService;
import com.sample.service.TuzilacService;
import com.sample.unit.KnowledgeSessionHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={StartApp.class})
public class TemplateTest {
	
	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;
	
	@Autowired
	DokazService dokazService;
	
	@Autowired
	TuzilacService tuzilacService;
	
	KieSession kieSession = null;
	static KieContainer kieContainer;
	
	@Before
	public void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Test
	@Rollback
	public void templateTest() {
		NovoDelo novoDelo = addNovoDelo();
		QueryDataList.getInstance().clear();
		QueryDataList.getInstance().put("age2", novoDelo.getZrtva());
		QueryDataList.getInstance().put("subOdnos", novoDelo.getSubjOdnos());
		QueryDataList.getInstance().put("mesto", novoDelo.getMesto());
		QueryDataList.getInstance().put("radnja", novoDelo.getRadnja());
		QueryDataList.getInstance().put("stanje", novoDelo.getStanje());
		QueryDataList.getInstance().put("broj", novoDelo.getBrZrtava());
		QueryDataList.getInstance().put("izvrsilacStanje", novoDelo.getPsihickoStanje());
		
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
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
 		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> templatePodaci = (Collection<PodaciODelu>) KSessionModel.getInstance().getkSession().getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> templatePodaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : templatePodaci) {
			templatePodaciODelu.add(p);
			kSession.insert(p);
		}
		
        int fired = kSession.fireAllRules();
        
        @SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);
		
		assertEquals(2, templateFired);
		assertEquals(1, fired);
		assertEquals("Genocid", podaciODelu.get(0).getDelo().getNaziv());
		assertEquals(TipTuzioca.TUZILAC_ZA_RATNE_ZLOCINE, podaciODelu.get(0).getTuzilac().getTip());
	}
	
	@Test
	@Rollback
	public void testWithoutTemplate() {
		NovoDelo novoDelo = generateNovoDelo();
		
		QueryDataList.getInstance().clear();
		QueryDataList.getInstance().put("age2", novoDelo.getZrtva());
		QueryDataList.getInstance().put("subOdnos", novoDelo.getSubjOdnos());
		QueryDataList.getInstance().put("mesto", novoDelo.getMesto());
		QueryDataList.getInstance().put("radnja", novoDelo.getRadnja());
		QueryDataList.getInstance().put("stanje", novoDelo.getStanje());
		QueryDataList.getInstance().put("broj", novoDelo.getBrZrtava());
		QueryDataList.getInstance().put("izvrsilacStanje", novoDelo.getPsihickoStanje());
		
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
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
 		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> templatePodaci = (Collection<PodaciODelu>) KSessionModel.getInstance().getkSession().getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> templatePodaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : templatePodaci) {
			templatePodaciODelu.add(p);
			kSession.insert(p);
		}
		
        int fired = kSession.fireAllRules();
        
        @SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);
		
		assertEquals(0, templateFired);
		assertEquals(0, fired);
	}
	
	private NovoDelo addNovoDelo() {
		NovoDelo novoDelo = generateNovoDelo();
		
		Obelezje oobelezje = new Obelezje();
		oobelezje.setMesto(novoDelo.getMesto());
		oobelezje.setRadnja(novoDelo.getRadnja());
		oobelezje.setSubjektivanOdnos(novoDelo.getSubjOdnos());
		obelezjeService.save(oobelezje);
		
		Obelezje pobelezje = new Obelezje();
		pobelezje.setZrtva(novoDelo.getZrtva());
		obelezjeService.save(pobelezje);
		
		Delo delo = new Delo();
		delo.setClan(Integer.parseInt(novoDelo.getClan()));
		delo.setStav(Integer.parseInt(novoDelo.getStav()));
		delo.setTacka(Integer.parseInt(novoDelo.getTacka()));
		delo.setNaziv(novoDelo.getNaziv());
		delo.setMaxKazna(Double.parseDouble(novoDelo.getMax_kazna()));
		delo.setMinKazna(Double.parseDouble(novoDelo.getMin_kazna()));
		delo.setOpsteObelezje(oobelezje);
		delo.setPosebnoObelezje(pobelezje);
		
		Dokaz dokaz = new Dokaz();
		dokaz.setOpis(novoDelo.getDokazi());
		dokaz.setClan(Integer.parseInt(novoDelo.getClan()));
		dokaz.setStav(Integer.parseInt(novoDelo.getStav()));
		dokaz.setTacka(Integer.parseInt(novoDelo.getTacka()));
		System.out.println(dokaz);
		
		deloService.save(delo);
		dokazService.save(dokaz);
		
		KSessionModel.getInstance().addNovoDelo(novoDelo);
		return novoDelo;
	}
	
	private NovoDelo generateNovoDelo() {
		NovoDelo novoDelo = new NovoDelo();
		novoDelo.setNaziv("Genocid");
		novoDelo.setMin_kazna("12");
		novoDelo.setMax_kazna("100");
		novoDelo.setClan("6");
		novoDelo.setStav("5");
		novoDelo.setTacka("4");
		novoDelo.setZrtva("Vise od 18");
		novoDelo.setSubjOdnos("Umisljaj");
		novoDelo.setStanje("Ratno stanje");
		novoDelo.setMesto("Napolju");
		novoDelo.setRadnja("Udarac");
		novoDelo.setBrZrtava("Vise");
		novoDelo.setPsihickoStanje("nema podataka");
		novoDelo.setDokazi("");
		
		return novoDelo;
	}

}
