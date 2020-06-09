package com.sample.model;

import org.kie.api.definition.type.Position;

public class LinkT {
	
	@Position(0)
	private String tuzilac;
	
	@Position(1)
	private int clan;

	@Position(2)
	private int stav;
	
	@Position(3)
	private int tacka;
	
	

	public LinkT(String tuzilac, int clan, int stav, int tacka) {
		super();
		this.tuzilac = tuzilac;
		this.clan = clan;
		this.stav = stav;
		this.tacka = tacka;
	}

	public String getTuzilac() {
		return tuzilac;
	}

	public void setTuzilac(String tuzilac) {
		this.tuzilac = tuzilac;
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
