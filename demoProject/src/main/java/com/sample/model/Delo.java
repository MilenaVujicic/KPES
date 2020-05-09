package com.sample.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private double maxKazna;
	@Column
	private double minKazna;
	@Column
	private int clan;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Obelezje opsteObelezje;
	@OneToOne(cascade = CascadeType.ALL)
	private Obelezje posebnoObelezje;
	@Column
	private int stav;
	@Column
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
