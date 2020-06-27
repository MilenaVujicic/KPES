package com.sample.model;

import java.util.ArrayList;
import java.util.List;

public class PodaciODelu {

	private Delo delo;
	private List<Dokaz> dokazi = new ArrayList<Dokaz>();
	private Tuzilac tuzilac;
	private String stanje;
	
	public PodaciODelu(Delo delo, List<Dokaz> dokazi, Tuzilac tuzilac, String stanje) {
		this.tuzilac = tuzilac;
		this.dokazi = dokazi;
		this.delo = delo;
		this.stanje = stanje;
	}
	
	public PodaciODelu(Delo delo, List<Dokaz> dokazi) {
		this.delo = delo;
		this.dokazi = dokazi;
	}
	
	public PodaciODelu(Delo delo) {
		this.delo = delo;
	}
	
	public PodaciODelu(Delo delo, String stanje) {
		super();
		this.delo = delo;
		this.stanje = stanje;
	}

	public PodaciODelu() {
		
	}

	public Delo getDelo() {
		return delo;
	}

	public void setDelo(Delo delo) {
		this.delo = delo;
	}

	public List<Dokaz> getDokazi() {
		return dokazi;
	}

	public void setDokazi(List<Dokaz> dokazi) {
		this.dokazi = dokazi;
	}

	public Tuzilac getTuzilac() {
		return tuzilac;
	}

	public void setTuzilac(Tuzilac tuzilac) {
		this.tuzilac = tuzilac;
	}

	public String getStanje() {
		return stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}

	public boolean compareDelo(Delo d) {
		if(d.getId().equals(this.delo.getId()))
			return true;
		return false;
	}
	
	public void addToList(Dokaz d) {
		if(d != null)
			this.dokazi.add(d);
	}
	@Override
	public String toString() {
		return "PodaciODelu [delo=" + delo + ", dokazi=" + dokazi + ", tuzilac=" + tuzilac + ", stanje=" + stanje + "]";
	}

	

	
}
