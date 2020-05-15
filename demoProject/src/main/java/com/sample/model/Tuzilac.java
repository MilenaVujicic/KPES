package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
public class Tuzilac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@Column
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

	public boolean compareTip(TipTuzioca tip) {
		if(tip != null)
			return false;
		
		if(this.tip.equals(tip))
			return true;
		
		return false;
	} 
	@Override
	public String toString() {
		return "Tuzilac [tip=" + tip + "]";
	}
	
	
}
