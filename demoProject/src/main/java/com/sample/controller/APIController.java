package com.sample.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.QueryDataList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
@RequestMapping(value = "data")
public class APIController {

	
	@RequestMapping(value = "/sendData", method = RequestMethod.POST)
	public ResponseEntity<?> sendData(HttpEntity<String> json) throws ParseException{
		String jString = json.getBody();
		QueryDataList.getInstance().clear();
		
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		JSONArray jArr = (JSONArray) jObj.get("subOdnos");
		String subOdnos = jArr.get(0).toString();
		if(jObj.get("subOdnos") != null) {
			QueryDataList.getInstance().put("subjektivni_odnos",  subOdnos);
		}else if(jObj.get("starostZrtve") != null) {
		}
		System.out.println(QueryDataList.getInstance().toString());
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
