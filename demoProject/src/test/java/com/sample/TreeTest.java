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
import com.sample.model.DokazLeaf;
import com.sample.model.DokazRoot;
import com.sample.model.Obelezje;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazLeafService;
import com.sample.service.DokazRootService;
import com.sample.service.ObelezjeService;
import com.sample.service.TuzilacService;
import com.sample.unit.KnowledgeSessionHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={StartApp.class})
public class TreeTest {
	

	@Autowired
	DeloService deloService;
	
	@Autowired
	ObelezjeService obelezjeService;

	@Autowired
	DokazLeafService dokazLeafService;
	
	@Autowired
	DokazRootService dokazRootService;
	
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
		
		
		/*String oIzvrsilac = "svako";
		String oVreme = "svako";
		String oMesto = "svako";
		String oRadnja = "podobna da prouzrokuje smrt";
		String oPosledica = "smrt, odmah ili kasnije";
		String oSubOdnos =  "umisljaj";
		String oZrtva = "Vise od 18";
		
		String pZrtva = "poseban status";
		String pNacin = null;
		String pRadnja = null;
		String pIzvrsilac = null;
		String pSubOdnos = "ugrozavanje ustavnog uredjenja";*/
		
		
		String oIzvrsilac = "svako";
		String oVreme = "svako";
		String oMesto = "svako";
		String oRadnja = "podobna da prouzrokuje smrt";
		String oPosledica = "smrt, odmah ili kasnije";
		String oSubOdnos =  "umisljaj";
		String oZrtva =null;
		
		String pZrtva = "Vise od 18";
		String pNacin = null;
		String pRadnja = "bezobzirno nasilnicko ponasanje";
		String pIzvrsilac = null;
		String pSubOdnos = null;
		
		Obelezje ob = new Obelezje();
		//o.setIzvrsilac(oIzvrsilac);
		ob.setIzvrsilac(oIzvrsilac);
		ob.setVreme(oVreme);
		ob.setMesto(oMesto);
		ob.setRadnja(oRadnja);
		ob.setPosledica(oPosledica);
		ob.setSubjektivanOdnos(oSubOdnos);
		ob.setZrtva(oZrtva);
		kSession.insert(ob);
		
		Obelezje po = new Obelezje();
		po.setZrtva(pZrtva);
		po.setNacin(pNacin);
		po.setRadnja(pRadnja);
		po.setIzvrsilac(pIzvrsilac);
		po.setSubjektivanOdnos(pSubOdnos);
		kSession.insert(po);
	
		/*kSession.insert(oIzvrsilac);
		kSession.insert(oVreme);
		kSession.insert(oMesto);
		kSession.insert(oRadnja);
		kSession.insert(oPosledica);
		kSession.insert(oSubOdnos);
		*/
		kSession.insert(pZrtva);
		kSession.insert(pNacin);
		kSession.insert(pRadnja);
		kSession.insert(pIzvrsilac);
		kSession.insert(pSubOdnos);
		
		List<Delo> dela = deloService.findAll();
		for(Delo d : dela)
			kSession.insert(d);
		
		List<Obelezje> obelezja = obelezjeService.findAll();
		for(Obelezje o : obelezja)
			kSession.insert(o);
	
		List<Tuzilac> tuzioci = tuzilacService.findAll();
		for(Tuzilac t : tuzioci)
			kSession.insert(t);
		
		/*int begin = 	kSession.getObjects().size();
		System.out.println(begin);*/
		List<DokazRoot> dokazRoots = dokazRootService.findAll();
		for(DokazRoot dr : dokazRoots)
		{	
			/*try {
				System.out.println("BEGIN PRINT");
				System.out.println("D " + dr.toString());
				System.out.println("END PRINT");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			*/
			//System.out.println(dokazRoots.size());
			kSession.insert(dr);
		}
		List<DokazLeaf> dokazLeaves = dokazLeafService.findAll();
		for(DokazLeaf dl : dokazLeaves)
			kSession.insert(dl);
		
		/*int end = 	kSession.getObjects().size();
		System.out.println(end);
	*/
		int firedFirstTime = kSession.fireAllRules();
		System.out.println(firedFirstTime);
	}
	
}
