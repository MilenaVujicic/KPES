package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tuzilac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipTuzioca tip;

	public Tuzilac() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tuzilac(TipTuzioca tip) {
		super();
		this.tip = tip;
	}



	public TipTuzioca getTip() {
		return tip;
	}

	public void setTip(TipTuzioca tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "Tuzilac [tip=" + tip + "]";
	}
	
	
}
