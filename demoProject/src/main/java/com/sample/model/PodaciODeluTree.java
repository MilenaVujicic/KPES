package com.sample.model;

import java.util.ArrayList;
import java.util.List;

public class PodaciODeluTree {
	
	private Delo delo;
	private List<DokazRoot> dokazi = new ArrayList<DokazRoot>();
	private Tuzilac tuzilac;
	
	public PodaciODeluTree(Delo delo, List<DokazRoot> dokazi, Tuzilac tuzilac) {
		this.tuzilac = tuzilac;
		this.dokazi = dokazi;
		this.delo = delo;
	}
	
	public PodaciODeluTree(Delo delo, List<DokazRoot> dokazi) {
		this.delo = delo;
		this.dokazi = dokazi;
	}
	
	public PodaciODeluTree(Delo delo) {
		this.delo = delo;
	}

	public PodaciODeluTree() {
		
	}

	public Delo getDelo() {
		return delo;
	}

	public void setDelo(Delo delo) {
		this.delo = delo;
	}

	public List<DokazRoot> getDokazi() {
		return dokazi;
	}

	public void setDokazi(List<DokazRoot> dokazi) {
		this.dokazi = dokazi;
	}

	public Tuzilac getTuzilac() {
		return tuzilac;
	}

	public void setTuzilac(Tuzilac tuzilac) {
		this.tuzilac = tuzilac;
	}

	public boolean compareDelo(Delo d) {
		if(d.getId().equals(this.delo.getId()))
			return true;
		return false;
	}
	
	public void addToList(DokazRoot d) {
		if(d != null)
			this.dokazi.add(d);
	}
	@Override
	public String toString() {
		return "PodaciODelu [delo=" + delo + ", dokazi=" + dokazi + ", tuzilac=" + tuzilac + "]";
	}
}
