package com.sample.model;

import java.util.HashMap;

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
}
