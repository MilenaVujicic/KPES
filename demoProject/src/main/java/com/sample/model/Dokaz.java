package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dokaz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int clan;
	@Column
	private String opis;
	@Column
	private int stav;
	@Column
	private int tacka;
	public Dokaz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClan() {
		return clan;
	}

	public void setClan(int clan) {
		this.clan = clan;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
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
		return "Dokaz [clan=" + clan + ", opis=" + opis + ", stav=" + stav + ", tacka=" + tacka + "]";
	}
	
	
}
