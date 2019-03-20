package com.java.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class JSONCreation {
	
	public static void main(String [] args) throws IOException
	{
		String userdir=System.getProperty("user.dir");
        String csvFileName=userdir+"\\Files\\Tree.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName)));
       String line="";
       int noofrows=0;
        while ((line = reader.readLine()) != null) {
        	
        	String n=line.trim();
        	String n1=line.replaceAll("\\s{2,}","").trim();
        	String [] nam=line.split("\\s{2,}");
        	if(noofrows>1)
        	noofrows++;
        }
       
  

		
		JSONObject json = new JSONObject();
		json.put("port", "value");
		JSONObject json2 = new JSONObject();
		json2.put("Name", json);
		JSONObject json22 = new JSONObject();
		json22.put("Name", json);
		
		JSONObject json3 = new JSONObject();
		json3.put("Namespace", json2);
		
		JSONObject json5= json3.getJSONObject("Namespace");
		json5.put("Name2", json);
		//json3.put("Name3", json2);
		String newFileName=System.getProperty("user.dir")+"jasonfile"+".json";
		File f = new File(newFileName);
		System.out.println(newFileName);
		FileWriter fileWriter = new FileWriter(newFileName);
		fileWriter.write(json3.toString());
		fileWriter.flush();
		
	}

}
