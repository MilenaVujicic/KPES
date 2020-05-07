package com.sample.model;

public class Delo {
	
	private String naziv;
	private double maxKazna;
	private double minKazna;
	private int clan;
	private Obelezje opsteObelezje;
	private Obelezje posebnoObelezje;
	private int stav;
	private int tacka;
	
	public Delo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getMaxKazna() {
		return maxKazna;
	}

	public void setMaxKazna(double maxKazna) {
		this.maxKazna = maxKazna;
	}

	public double getMinKazna() {
		return minKazna;
	}

	public void setMinKazna(double minKazna) {
		this.minKazna = minKazna;
	}

	public int getClan() {
		return clan;
	}

	public void setClan(int clan) {
		this.clan = clan;
	}

	public Obelezje getOpsteObelezje() {
		return opsteObelezje;
	}

	public void setOpsteObelezje(Obelezje opsteObelezje) {
		this.opsteObelezje = opsteObelezje;
	}

	public Obelezje getPosebnoObelezje() {
		return posebnoObelezje;
	}

	public void setPosebnoObelezje(Obelezje posebnoObelezje) {
		this.posebnoObelezje = posebnoObelezje;
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
		return "Delo [naziv=" + naziv + ", maxKazna=" + maxKazna + ", minKazna=" + minKazna + ", clan=" + clan
				+ ", opsteObelezje=" + opsteObelezje + ", posebnoObelezje=" + posebnoObelezje + ", stav=" + stav
				+ ", tacka=" + tacka + "]";
	}
	
	
}
