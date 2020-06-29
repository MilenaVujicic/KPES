package com.sample.controller;

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
		System.out.println(dokaz);
		
		deloService.save(delo);
		dokazService.save(dokaz);
		
		KSessionModel.getInstance().addNovoDelo(novoDelo);
        
	}
}
