package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Delo;
import com.sample.model.Dokaz;
import com.sample.model.Tuzilac;
import com.sample.service.DeloService;
import com.sample.service.DokazService;
import com.sample.service.TuzilacService;

@RestController
@RequestMapping(value = "/list")
public class ListController {

	@Autowired
	private TuzilacService tuzilacService;
	
	@Autowired
	private DeloService deloService;
	
	@Autowired
	private DokazService dokazService;
	
	@GetMapping(value = "/tuzioci")
	public List<Tuzilac> getTuzioci() {
		return tuzilacService.findAll();
	}
	
	@GetMapping(value = "/dela")
	public List<Delo> getDela() {
		List<Delo> svaDela = deloService.findAll();
		List<Delo> povratna = new ArrayList<Delo>();
		for (Delo delo : svaDela) {
			boolean found = false;
			for (Delo d : povratna) {
				if (delo.getNaziv().equals(d.getNaziv()))
					found = true;
			}
			if (!found)
				povratna.add(delo);
		}
		return povratna;
	}
	
	@GetMapping(value = "/dokazi")
	public List<Dokaz> getDokazi() {
		return dokazService.findAll();
	}
	
}
