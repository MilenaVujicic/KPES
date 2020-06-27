package com.sample.model;

import org.kie.api.runtime.KieSession;

public class KSessionModel {

	KieSession kSession;
	private static KSessionModel instance;
	
	public KSessionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KieSession getkSession() {
		return kSession;
	}

	public void setkSession(KieSession kSession) {
		this.kSession = kSession;
	}

	public static KSessionModel getInstance() {
		if (instance == null)
			instance = new KSessionModel();
		
		return instance;
	}

	public static void setInstance(KSessionModel instance) {
		KSessionModel.instance = instance;
	}
	
	
	
	
}
