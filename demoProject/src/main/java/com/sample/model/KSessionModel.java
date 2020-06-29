package com.sample.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import com.sample.controller.NovoDeloController;

public class KSessionModel {

	private KieSession kSession;
	private ArrayList<NovoDelo> dela = new ArrayList<NovoDelo>();
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

	public ArrayList<NovoDelo> getDela() {
		return dela;
	}

	public void setDela(ArrayList<NovoDelo> dela) {
		this.dela = dela;
	}

	public static KSessionModel getInstance() {
		if (instance == null)
			instance = new KSessionModel();
		
		return instance;
	}

	public static void setInstance(KSessionModel instance) {
		KSessionModel.instance = instance;
	}
	
	public void addNovoDelo(NovoDelo novoDelo) {
		this.dela.add(novoDelo);
	}
	
	public void createDRL() {
		InputStream template = NovoDeloController.class.getResourceAsStream("/dtables/templates.drt");
		ObjectDataCompiler converter = new ObjectDataCompiler();

        String drl = converter.compile(this.dela, template);
        
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: " + message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        this.kSession = kieHelper.build().newKieSession();
        System.out.println(drl);
	}
	
	
	
}
