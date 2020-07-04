package com.sample.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.kie.api.definition.type.Position;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DokazRoot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Position(0)
	private int clan;
	@Column
	@Position(1)
	private int stav;
	@Column
	@Position(2)
	private int tacka;
	@Column
	@Position(3)
	private String osnovniOpis;

	@JsonIgnore
	private Set<DokazLeaf> dodatniOpis;
	
	public DokazRoot() {
		
	}
	
	public DokazRoot(int clan, int stav, int tacka, String osnovniOpis) {
		super();
		this.clan = clan;
		this.stav = stav;
		this.tacka = tacka;
		this.osnovniOpis = osnovniOpis;
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
				+ osnovniOpis + "]";
	}
	
	
}
