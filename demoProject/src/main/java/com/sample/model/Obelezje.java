package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Obelezje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String izvrsilac;
	@Column
	private String vreme;
	@Column
	private String mesto;
	@Column
	private String radnja;
	@Column
	private String posledica;
	@Column
	private String subjektivanOdnos;
	@Column
	private String zrtva;
	@Column
	private String nacin;
	
	@JsonIgnore
	@OneToOne(mappedBy = "opsteObelezje")
	private Delo delo1;
	
	@JsonIgnore
	@OneToOne(mappedBy = "posebnoObelezje")
	private Delo delo2;
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

	public String getZrtva() {
		return zrtva;
	}

	public void setZrtva(String zrtva) {
		this.zrtva = zrtva;
	}

	public String getNacin() {
		return nacin;
	}

	public void setNacin(String nacin) {
		this.nacin = nacin;
	}
	
	

	public Delo getDelo1() {
		return delo1;
	}

	public void setDelo1(Delo delo1) {
		this.delo1 = delo1;
	}

	public Delo getDelo2() {
		return delo2;
	}

	public void setDelo2(Delo delo2) {
		this.delo2 = delo2;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Obelezje [id=" + id + ", izvrsilac=" + izvrsilac + ", vreme=" + vreme + ", mesto=" + mesto + ", radnja="
				+ radnja + ", posledica=" + posledica + ", subjektivanOdnos=" + subjektivanOdnos + ", zrtva=" + zrtva
				+ ", nacin=" + nacin + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Obelezje o = (Obelezje) obj;
		
		if(o.getId() != null && o.getId().equals(id))
			return true;
	
		if(o.getIzvrsilac() != null && !o.getIzvrsilac().equals(izvrsilac))
			return false;
		else if(o.getIzvrsilac() == null && izvrsilac != null)
			return false;
		
		if(o.getMesto() != null && !o.getMesto().equals(mesto))
			return false;
		else if(o.getMesto() == null && mesto != null)
			return false;
		
		if(o.getNacin() != null && !o.getNacin().equals(nacin))
			return false;
		else if(o.getNacin() == null && nacin != null)
			return false;
		
		if(o.getPosledica() != null && !o.getPosledica().equals(posledica))
			return false;
		else if(o.getPosledica() == null && posledica != null)
			return false;
		
		if(o.getRadnja() != null && !o.getRadnja().equals(radnja))
			return false;
		else if(o.getRadnja() == null && radnja != null)
			return false;
		
		if(o.getSubjektivanOdnos() != null && !o.getSubjektivanOdnos().equals(subjektivanOdnos))
			return false;
		else if(o.getSubjektivanOdnos() == null && subjektivanOdnos != null)
			return false;
		
		if(o.getVreme() != null && !o.getVreme().equals(vreme))
			return false;
		else if(o.getVreme() == null && vreme != null)
			return false;
		
		if(o.getZrtva() != null && !o.getZrtva().equals(zrtva))
			return false;
		else if(o.getZrtva() == null && zrtva != null)
			return false;
		
		/*if((o.getIzvrsilac().equals(izvrsilac) && o.getMesto().equals(mesto) &&
				o.getNacin().equals(nacin) && o.getPosledica().equals(posledica) && o.getRadnja().equals(radnja) &&
				o.getSubjektivanOdnos().equals(subjektivanOdnos) && o.getVreme().equals(vreme) && o.getZrtva().equals(zrtva))
				|| o.getId().equals(id))
			return true;
			*/
		
		return true;
	}
	
	
	
	
}
