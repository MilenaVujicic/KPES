package com.sample.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DokazRoot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int clan;
	@Column
	private int stav;
	@Column
	private int tacka;
	@Column
	private String osnovniOpis;
	@OneToMany(mappedBy = "dokazParent")
	private Set<DokazLeaf> dodatniOpis;
	
	public DokazRoot() {
		
	}
	
	
	
	public DokazRoot(Long id, int clan, int stav, int tacka, String osnovniOpis, Set<DokazLeaf> dodatniOpis) {
		super();
		this.id = id;
		this.clan = clan;
		this.stav = stav;
		this.tacka = tacka;
		this.osnovniOpis = osnovniOpis;
		this.dodatniOpis = dodatniOpis;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getOsnovniOpis() {
		return osnovniOpis;
	}
	public void setOsnovniOpis(String osnovniOpis) {
		this.osnovniOpis = osnovniOpis;
	}
	public Set<DokazLeaf> getDodatniOpis() {
		return dodatniOpis;
	}
	public void setDodatniOpis(Set<DokazLeaf> dodatniOpis) {
		this.dodatniOpis = dodatniOpis;
	}
	@Override
	public String toString() {
		return "DokazRoot [id=" + id + ", clan=" + clan + ", stav=" + stav + ", tacka=" + tacka + ", osnovniOpis="
				+ osnovniOpis + ", dodatniOpis=" + dodatniOpis + "]";
	}
	
	
}
