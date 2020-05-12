package com.sample;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.model.Delo;
import com.sample.model.Obelezje;
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
	
	@Test
	public void testiranje() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		Obelezje o1 = new Obelezje();
		o1.setSubjektivanOdnos("nehat");
		
		Obelezje o2 = new Obelezje();
		o2.setRadnja("tokom razbojnistva ili razbojnicke kradje");
		o2.setZrtva(">18");
		
		List<Delo> dela = deloService.findAll();
		for (Delo d : dela) {
			kSession.insert(d);
		}
		
		kSession.insert(o1);
		kSession.insert(o2);
		kSession.getAgenda().getAgendaGroup("odredjivanjeClana").setFocus();
		int firedFirstTime = kSession.fireAllRules();
		System.out.println(firedFirstTime);

		kSession.getAgenda().getAgendaGroup("odredjivanjeTuzioca").setFocus();
		int firedSecondTime = kSession.fireAllRules();
		System.out.println(firedSecondTime);
		
		assertEquals(2, firedFirstTime);
		assertEquals(1, firedSecondTime);
		assertEquals(118, o1.getDelo2().getClan());
	}
}
