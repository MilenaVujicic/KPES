package com.sample.model;

import org.kie.api.definition.type.Position;

public class LinkD {

	@Position(0)
	private String dokaz;
	
	@Position(1)
	private int clan;
	
	@Position(2)
	private int stav;
	
	@Position(3)
	private int tacka;

	public LinkD(String dokaz, int clan, int stav, int tacka) {
		super();
		this.dokaz = dokaz;
		this.clan = clan;
		this.stav = stav;
		this.tacka = tacka;
	}

	public String getDokaz() {
		return dokaz;
	}

	public void setDokaz(String dokaz) {
		this.dokaz = dokaz;
	}

	public int getClan() {
		return clan;
	}

	public void setClan(int clan) {
		this.clan = clan;
	}

	public int getStav() {
		return stav;
	}

	public void setStav(int stav) {
		this.stav = stav;
	}

	public int getTacka() {
		return tacka;
	}

	public void setTacka(int tacka) {
		this.tacka = tacka;
	}
	
	
}

