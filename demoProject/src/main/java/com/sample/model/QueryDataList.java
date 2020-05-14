package com.sample.model;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class QueryDataList extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static QueryDataList instance;
	
	public QueryDataList() {
		super();
	}
	
	
	public static QueryDataList getInstance() {
		if(instance == null) {
			instance = new QueryDataList();
		}

		return instance;
	}


	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return super.containsKey(key);
	}


	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return super.containsValue(value);
	}


	@Override
	public void forEach(BiConsumer<? super String, ? super String> action) {
		// TODO Auto-generated method stub
		super.forEach(action);
	}


	@Override
	public String get(Object key) {
		// TODO Auto-generated method stub
		return super.get(key);
	}


	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return super.put(key, value);
	}


	@Override
	public String remove(Object key) {
		// TODO Auto-generated method stub
		return super.remove(key);
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	
	
}
