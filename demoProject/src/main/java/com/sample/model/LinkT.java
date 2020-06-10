package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.kie.api.definition.type.Position;

@Entity
public class LinkT {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Position(0)
	private String tuzilac;
	
	@Column
	@Position(1)
	private int clan;

	@Column
	@Position(2)
	private int stav;
	
	@Column
	@Position(3)
	private int tacka;
	
	public LinkT() {
		super();
	}

	public LinkT(String tuzilac, int clan, int stav, int tacka) {
		super();
		this.tuzilac = tuzilac;
		this.clan = clan;
		this.stav = stav;
		this.tacka = tacka;
	}
	
	public LinkT(String tuzilac) {
		super();
		this.tuzilac = tuzilac;
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
		return "LinkT [id=" + id + ", tuzilac=" + tuzilac + ", clan=" + clan + ", stav=" + stav + ", tacka=" + tacka
				+ "]";
	}
	
	

}
