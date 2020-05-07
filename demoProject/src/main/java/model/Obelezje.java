package model;

import java.util.List;

public class Obelezje {

	private String izvrsilac;
	private String vreme;
	private String mesto;
	private String radnja;
	private String posledica;
	private String subjektivanOdnos;
	private List<String> zrtva;
	private String nacin;
	
	public Obelezje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIzvrsilac() {
		return izvrsilac;
	}

	public void setIzvrsilac(String izvrsilac) {
		this.izvrsilac = izvrsilac;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
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

	public String getPosledica() {
		return posledica;
	}

	public void setPosledica(String posledica) {
		this.posledica = posledica;
	}

	public String getSubjektivanOdnos() {
		return subjektivanOdnos;
	}

	public void setSubjektivanOdnos(String subjektivanOdnos) {
		this.subjektivanOdnos = subjektivanOdnos;
	}

	public List<String> getZrtva() {
		return zrtva;
	}

	public void setZrtva(List<String> zrtva) {
		this.zrtva = zrtva;
	}

	public String getNacin() {
		return nacin;
	}

	public void setNacin(String nacin) {
		this.nacin = nacin;
	}

	@Override
	public String toString() {
		return "Obelezje [izvrsilac=" + izvrsilac + ", vreme=" + vreme + ", mesto=" + mesto + ", radnja=" + radnja
				+ ", posledica=" + posledica + ", subjektivanOdnos=" + subjektivanOdnos + ", zrtva=" + zrtva
				+ ", nacin=" + nacin + "]";
	}
	
	
	
	
}
