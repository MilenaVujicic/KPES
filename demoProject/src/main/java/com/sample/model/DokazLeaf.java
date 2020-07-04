package com.sample.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DokazLeaf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String opis;
	@ManyToOne
	private DokazRoot dokazParent;
	@ManyToOne(fetch = FetchType.EAGER)
	private DokazLeaf opisParent;
	@OneToMany(mappedBy = "opisParent", fetch = FetchType.EAGER)
	private Set<DokazLeaf> opisChild;
	
	public DokazLeaf() {
		
	}
	
	
	public DokazLeaf(Long id, String opis, DokazRoot dokazParent, DokazLeaf opisParent, Set<DokazLeaf> opisChild) {
		super();
		this.id = id;
		this.opis = opis;
		this.dokazParent = dokazParent;
		this.opisParent = opisParent;
		this.opisChild = opisChild;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public DokazRoot getDokazParent() {
		return dokazParent;
	}
	public void setDokazParent(DokazRoot dokazParent) {
		this.dokazParent = dokazParent;
	}
	public DokazLeaf getOpisParent() {
		return opisParent;
	}
	public void setOpisParent(DokazLeaf opisParent) {
		this.opisParent = opisParent;
	}
	public Set<DokazLeaf> getOpisChild() {
		return opisChild;
	}
	public void setOpisChild(Set<DokazLeaf> opisChild) {
		this.opisChild = opisChild;
	}

/*
	@Override
	public String toString() {
		return "DokazLeaf [id=" + id + ", opis=" + opis + ", dokazParent=" + dokazParent + ", opisParent=" + opisParent
				+ ", opisChild=" + opisChild + "]";
	}
	
	*/
	
	
	@Override
	public String toString() {
		return "DokazLeaf [id=" + id + "]";
	}
	
	

}
