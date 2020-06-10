package com.sample.model;

public class LinkDAnswer {

	private String dokaz;
	
	private int clan;
	
	private int stav;
	
	private int tacka;
	
	public LinkDAnswer() {
		super();
	}

	public LinkDAnswer(String dokaz, int clan, int stav, int tacka) {
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

	@Override
	public String toString() {
		return "LinkDAnswer [dokaz=" + dokaz + ", clan=" + clan + ", stav=" + stav + ", tacka=" + tacka + "]";
	}
	
	
}
