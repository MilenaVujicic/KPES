package com.sample.model;

public class NovoDelo {

	private String naziv;
	private String min_kazna;
	private String max_kazna;
	private String clan;
	private String stav;
	private String tacka;
	private String zrtva;
	private String subjOdnos;
	private String stanje;
	private String mesto;
	private String radnja;
	private String brZrtava;
	private String psihickoStanje;
	private String dokazi;
	
	public NovoDelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMin_kazna() {
		return min_kazna;
	}
	public void setMin_kazna(String min_kazna) {
		this.min_kazna = min_kazna;
	}
	public String getMax_kazna() {
		return max_kazna;
	}
	public void setMax_kazna(String max_kazna) {
		this.max_kazna = max_kazna;
	}
	public String getClan() {
		return clan;
	}
	public void setClan(String clan) {
		this.clan = clan;
	}
	public String getStav() {
		return stav;
	}
	public void setStav(String stav) {
		this.stav = stav;
	}
	public String getTacka() {
		return tacka;
	}
	public void setTacka(String tacka) {
		this.tacka = tacka;
	}
	public String getZrtva() {
		return zrtva;
	}
	public void setZrtva(String zrtva) {
		this.zrtva = zrtva;
	}
	public String getSubjOdnos() {
		return subjOdnos;
	}
	public void setSubjOdnos(String subjOdnos) {
		this.subjOdnos = subjOdnos;
	}
	public String getStanje() {
		return stanje;
	}
	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getRadnja() {
		return radnja;
	}
	public void setRadnja(String radnja) {
		this.radnja = radnja;
	}
	public String getBrZrtava() {
		return brZrtava;
	}
	public void setBrZrtava(String brZrtava) {
		this.brZrtava = brZrtava;
	}
	public String getPsihickoStanje() {
		return psihickoStanje;
	}
	public void setPsihickoStanje(String psihickoStanje) {
		this.psihickoStanje = psihickoStanje;
	}
	public String getDokazi() {
		return dokazi;
	}
	public void setDokazi(String dokazi) {
		this.dokazi = dokazi;
	}
	@Override
	public String toString() {
		return "NovoDelo [naziv=" + naziv + ", min_kazna=" + min_kazna + ", max_kazna=" + max_kazna + ", clan=" + clan
				+ ", stav=" + stav + ", tacka=" + tacka + ", zrtva=" + zrtva + ", subjOdnos=" + subjOdnos + ", stanje="
				+ stanje + ", mesto=" + mesto + ", radnja=" + radnja + ", brZrtava=" + brZrtava + ", psihickoStanje="
				+ psihickoStanje + ", dokazi=" + dokazi + "]";
	}
	
	
	
}
