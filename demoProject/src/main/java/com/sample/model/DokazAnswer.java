package com.sample.model;

public class DokazAnswer {
	
	public DokazAnswer(String dokaz) {
		this.dokaz = dokaz;
	}
	
	private String dokaz;

	public String getDokaz() {
		return dokaz;
	}

	public void setDokaz(String dokaz) {
		this.dokaz = dokaz;
	}
	
	@Override
	public String toString() {
		return "DokazAnswer [dokaz=" + dokaz + "]";
	}
}
