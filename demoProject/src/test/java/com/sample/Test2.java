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
import com.sample.model.QueryDataList;
import com.sample.service.DeloService;
import com.sample.service.ObelezjeService;
import com.sample.unit.KnowledgeSessionHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={StartApp.class})
public class Test2 {

	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;
	
	KieSession kieSession = null;
	static KieContainer kieContainer;
	
	@Before
	public void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Test
	public void runTest() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
	
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("subOdnos", "nehat");
		kSession.insert(qdl);
	
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		int firedFirstTime = kSession.fireAllRules();
		
		assertEquals(1, firedFirstTime);
	
	}
}