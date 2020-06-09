package com.sample;

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
import com.sample.model.Dokaz;
import com.sample.model.LinkD;
import com.sample.model.LinkT;
import com.sample.model.Obelezje;
import com.sample.model.QueryDataList;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.ObelezjeService;
import com.sample.service.TuzilacService;
import com.sample.unit.KnowledgeSessionHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={StartApp.class})
public class BackwardChainingTest {
	
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
	public void runTest() {
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		QueryDataList qdl = QueryDataList.getInstance();
		qdl.put("tuzilac", "VISI_JAVNI_TUZILAC");
		qdl.put("dokaz", "Vestacenja eksperata");
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
 		
		
		kSession.insert(new LinkT("VISI_JAVNI_TUZILAC", 113, 0, 0));
		kSession.insert(new LinkT("VISI_JAVNI_TUZILAC", 114, 1, 4));
		kSession.insert(new LinkT("VISI_JAVNI_TUZILAC", 114, 1, 9));
		kSession.insert(new LinkT("VISI_JAVNI_TUZILAC", 114, 1, 11));
		kSession.insert(new LinkT("VISI_JAVNI_TUZILAC", 115, 0, 0));
		kSession.insert(new LinkT("OSNOVNI_JAVNI_TUZILAC", 118, 0, 0));
		kSession.insert(new LinkT("TUZILAC_ZA_ORGANIZOVANI_KRIMINAL", 310, 0, 0));

		kSession.insert(new LinkD("Vestacenja eksperata", 113,0,0));
		kSession.fireAllRules();
	}

}
