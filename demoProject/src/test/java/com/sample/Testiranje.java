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
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
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
public class Testiranje {

	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;
	
	@Autowired
	DokazService dokazService;
	
	@Autowired
	TuzilacService tuzilacService;
	
	KieSession kSession = null;
	static KieContainer kieContainer;
	
	
	@Before
	public void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Test
	public void testiranjeNehata() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("subOdnos", "Nehat");
		
		kSession.insert(qdl);
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		List<Dokaz> dokazi = dokazService.findAll();
		for(Dokaz d : dokazi)
			kSession.insert(d);
		
		List<Tuzilac> tuzioci = tuzilacService.findAll();
		for(Tuzilac t : tuzioci)
			kSession.insert(t);
        
		int fired = kSession.fireAllRules();
		
		System.out.println("####fired: " + fired);
		
		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);

		PodaciODelu podatakODelu = podaciODelu.get(podaciODelu.size() - 1);
		System.out.println(podatakODelu.getDokazi());
		assertEquals(TipTuzioca.OSNOVNI_JAVNI_TUZILAC, podatakODelu.getTuzilac().getTip());
		assertEquals(4, podatakODelu.getDokazi().size());
		
	}
	
	@Test
	public void testiranjeKradje() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("age2", "Vise od 18");
		qdl.put("radnja", "Kradja");
		
		
		kSession.insert(qdl);
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		List<Dokaz> dokazi = dokazService.findAll();
		for(Dokaz d : dokazi)
			kSession.insert(d);
		
		List<Tuzilac> tuzioci = tuzilacService.findAll();
		for(Tuzilac t : tuzioci)
			kSession.insert(t);
        
		int fired = kSession.fireAllRules();
		
		System.out.println("####fired: " + fired);
		
		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);

		PodaciODelu podatakODelu = podaciODelu.get(podaciODelu.size() - 1);
		System.out.println(podatakODelu.getDokazi());
		assertEquals(TipTuzioca.VISI_JAVNI_TUZILAC, podatakODelu.getTuzilac().getTip());
		assertEquals(4, podatakODelu.getDokazi().size());
	}
	
	@Test
	public void testiranjeRazbojnistvo() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("age2", "Vise od 18");
		qdl.put("radnja", "Razbojnistvo");
		
		
		kSession.insert(qdl);
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		List<Dokaz> dokazi = dokazService.findAll();
		for(Dokaz d : dokazi)
			kSession.insert(d);
		
		List<Tuzilac> tuzioci = tuzilacService.findAll();
		for(Tuzilac t : tuzioci)
			kSession.insert(t);
        
		int fired = kSession.fireAllRules();
		
		System.out.println("####fired: " + fired);
		
		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);

		PodaciODelu podatakODelu = podaciODelu.get(podaciODelu.size() - 1);
		System.out.println(podatakODelu.getDokazi());
		assertEquals(TipTuzioca.VISI_JAVNI_TUZILAC, podatakODelu.getTuzilac().getTip());
		assertEquals(4, podatakODelu.getDokazi().size());
	}
	
	@Test
	public void testiranjeMaloletnici() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("age2", "Izmedju 18 i 14");
		qdl.put("radnja", "Razbojnistvo");
		
		
		kSession.insert(qdl);
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		List<Dokaz> dokazi = dokazService.findAll();
		for(Dokaz d : dokazi)
			kSession.insert(d);
		
		List<Tuzilac> tuzioci = tuzilacService.findAll();
		for(Tuzilac t : tuzioci)
			kSession.insert(t);
        
		int fired = kSession.fireAllRules();
		
		System.out.println("####fired: " + fired);
		
		@SuppressWarnings("unchecked")
		Collection<PodaciODelu> podaci = (Collection<PodaciODelu>) kSession.getObjects(new ClassObjectFilter(PodaciODelu.class));
		ArrayList<PodaciODelu> podaciODelu = new ArrayList<PodaciODelu>();
		for (PodaciODelu p : podaci)
			podaciODelu.add(p);

		PodaciODelu podatakODelu = podaciODelu.get(podaciODelu.size() - 1);
		System.out.println(podatakODelu.getDokazi());
		assertEquals(TipTuzioca.VISI_JAVNI_TUZILAC, podatakODelu.getTuzilac().getTip());
		assertEquals(5, podatakODelu.getDokazi().size());
	}
}
