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
import com.sample.model.Obelezje;
import com.sample.model.TipTuzioca;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.ObelezjeService;
import com.sample.unit.KnowledgeSessionHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={StartApp.class})
public class Testiranje {

	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;
	
	KieSession kSession = null;
	static KieContainer kieContainer;
	
	
	@Before
	public void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	//private static final double DELTA = 1e-15;
	private static final int TEST_NUM = 5;
	
	@Test
	public void testiranje() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		Obelezje o1 = new Obelezje();
		o1.setSubjektivanOdnos("nehat");
		o1.setDelo1(new Delo());
		Obelezje o2 = new Obelezje();
		o2.setRadnja("tokom razbojnistva ili razbojnicke kradje");
		o2.setZrtva(">18");
		o2.setDelo1(new Delo());
		
		Delo delo1 = new Delo();
		delo1.setMaxKazna(7);
		
		Delo delo2 = new Delo();
		delo2.setMaxKazna(11);
		
		Delo delo3 = new Delo();
		delo3.setMaxKazna(9.9);
		
		List<Obelezje> obelezija = obelezjeService.findAll();
		System.out.println("###" + obelezija.size());
		
		
		kSession.insert(o1);
		kSession.insert(o2);
		kSession.insert(delo1);
		kSession.insert(delo2);
		kSession.insert(delo3);
		
		int fired = kSession.fireAllRules();
		
		@SuppressWarnings("unchecked")
		Collection<Tuzilac> tuz = (Collection<Tuzilac>) kSession.getObjects(new ClassObjectFilter(Tuzilac.class));
		ArrayList<Tuzilac> tuzioci = new ArrayList<Tuzilac>();
		for(Tuzilac t : tuz) {
			tuzioci.add(t);
		}
		
		assertEquals(fired, TEST_NUM);
		assertEquals(o1.getDelo1().getClan(), 118);
		assertEquals(o2.getDelo1().getClan(), 114);
		assertEquals(o2.getDelo1().getStav(), 1);
		assertEquals(o2.getDelo1().getTacka(), 9);
		assertEquals(tuz.size(), 2);
		assertEquals(tuzioci.get(0).getTip(), TipTuzioca.OSNOVNI_JAVNI_TUZILAC);
	}
}
