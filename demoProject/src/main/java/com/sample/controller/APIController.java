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
		System.out.println(jString);
		QueryDataList.getInstance().clear();
		
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		JSONArray jArrAge1 = (JSONArray) jObj.get("starost1");
		JSONArray jArrAge2 = (JSONArray) jObj.get("starost2");
		JSONArray jArrSubOdnos = (JSONArray) jObj.get("subOdnos");
		JSONArray jArrMesto = (JSONArray) jObj.get("mesto");
		JSONArray jArrRadnja = (JSONArray) jObj.get("radnja");
		JSONArray jArrStanje = (JSONArray) jObj.get("stanje");
		JSONArray jArrBroj = (JSONArray) jObj.get("broj");
	/*	JSONArray jArr = (JSONArray) jObj.get("subOdnos");
		
		String subOdnos = jArr.get(0).toString();
		if(jObj.get("subOdnos") != null) {
			QueryDataList.getInstance().put("subjektivni_odnos",  subOdnos);
		}else if(jObj.get("starostZrtve") != null) {
		}
		System.out.println(QueryDataList.getInstance().toString());*/
	
		String age1 = null;
		String age2 = null;
		String subOdnos = null;
		String mesto = null;
		String stanje = null;
		String broj = null;
		String radnja = null;
		
		for(Object o : jArrAge1) {
			if(age1 == null) {
				age1 = o.toString();
			}else{
				age1 += "&";
				age1 += o.toString();
			}
		}
		
		for(Object o : jArrAge2) {
			if(age2 == null) {
				age2 = o.toString();
			}else{
				age2 += "&";
				age2 += o.toString();
			}
		}
		
		for(Object o : jArrSubOdnos) {
			if(subOdnos == null) {
				subOdnos = o.toString();
			}else{
				subOdnos += "&";
				subOdnos += o.toString();
			}
		}
		
		
		for(Object o : jArrMesto) {
			if(mesto == null) {
				mesto = o.toString();
			}else{
				mesto += "&";
				mesto += o.toString();
			}
		}
		
		
		for(Object o : jArrRadnja) {
			if(radnja == null) {
				radnja = o.toString();
			}else{
				radnja += "&";
				radnja += o.toString();
			}
		}
		
		
		for(Object o : jArrStanje) {
			if(stanje == null) {
				stanje = o.toString();
			}else{
				stanje += "&";
				stanje += o.toString();
			}
		}
		
		
		for(Object o : jArrBroj) {
			if(broj == null) {
				broj = o.toString();
			}else{
				broj += "&";
				broj += o.toString();
			}
		}
		
		if(age1 != null && !age1.equals("nema podataka")) {
			QueryDataList.getInstance().put("age1", age1);
		}
		if(age2 != null && !age2.equals("nema podataka")) {
			QueryDataList.getInstance().put("age2", age2);
		}
		if(subOdnos != null && !subOdnos.equals("nema podataka")) {
			QueryDataList.getInstance().put("subOdnos", subOdnos);
		}
		if(mesto != null && !mesto.equals("nema podataka")) {
			QueryDataList.getInstance().put("mesto", mesto);
		}
		if(radnja != null && !radnja.equals("nema podataka")) {
			QueryDataList.getInstance().put("radnja", radnja);
		}
		if(stanje != null && !stanje.equals("nema podataka")) {
			QueryDataList.getInstance().put("stanje", stanje);
		}
		if(broj != null && !broj.equals("nema podataka")) {
			QueryDataList.getInstance().put("broj", broj);
		}
		
		System.out.println(QueryDataList.getInstance().toString());
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
