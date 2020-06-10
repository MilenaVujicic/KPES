package com.sample.model;

public class LinkTAnswer {

	private String tuzilac;
	
	private int clan;
	
	private int stav;
	
	private int tacka;
	
	public LinkTAnswer() {
		super();
	}

	public LinkTAnswer(String tuzilac, int clan, int stav, int tacka) {
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

	@Override
	public String toString() {
		return "LinkTAnswer [tuzilac=" + tuzilac + ", clan=" + clan + ", stav=" + stav + ", tacka=" + tacka + "]";
	}
	
	
}
