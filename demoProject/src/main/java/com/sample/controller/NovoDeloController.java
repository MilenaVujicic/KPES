package com.sample.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
import com.sample.model.KSessionModel;
import com.sample.model.NovoDelo;
import com.sample.model.Obelezje;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.ObelezjeService;

@RestController
@RequestMapping(value = "/delo")
public class NovoDeloController {
	
	@Autowired
	private DeloService deloService;
	
	@Autowired
	private DokazService dokazService;
	
	@Autowired
	private ObelezjeService obelezjeService;

	@PostMapping(value = "/dodajNovo")
	public void dodajNovo(@RequestBody NovoDelo novoDelo) {
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
		
		deloService.save(delo);
		dokazService.save(dokaz);
		
		
		InputStream template = NovoDeloController.class.getResourceAsStream("/dtables/templates.drt");
		if (template == null)
			System.out.println("null");
		
		ArrayList<NovoDelo> nList = new ArrayList<NovoDelo>();
		nList.add(novoDelo);
        ObjectDataCompiler converter = new ObjectDataCompiler();
        System.out.println("###");
        String drl = converter.compile(nList, template);
        
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        KSessionModel.getInstance().setkSession(kieHelper.build().newKieSession());
        
        System.out.println(drl);
	}
}
