package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.kie.api.definition.type.Position;

@Entity
public class LinkD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Position(0)
	private String dokaz;
	
	@Column
	@Position(1)
	private int clan;
	
	@Column
	@Position(2)
	private int stav;
	
	@Column
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

