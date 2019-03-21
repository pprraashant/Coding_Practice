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
		doingsomting();
	}

	public static void doingsomting() throws IOException
	{
		String userdir=System.getProperty("user.dir");
        String csvFileName=userdir+"\\Files\\Tree.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName)));
       String line="";
       int noofrows=0;
       String namespacetrack="";
       JSONObject json2 = new JSONObject();
       JSONObject jsonoriginial = new JSONObject();
        while ((line = reader.readLine()) != null) 
        {
        	String [] nam=line.split("\\s{2,}");
        	if(noofrows>=1)
        	{
        		if(namespacetrack.equals(""))
        			namespacetrack=nam[0];
        			String namespace=nam[0];
         		if(namespace.equals(namespacetrack))
        		{
        			
        			json2=getPortsJson(nam,json2);
        		
        		}
        		else
        		{
        			jsonoriginial.put(namespacetrack, json2);
        			
        			json2=new JSONObject();
        			json2=getPortsJson(nam,json2);
        			
        		}
        		namespacetrack=nam[0];
        }
        	noofrows++;
        }
  
        jsonoriginial.put(namespacetrack, json2);
        System.out.println("final json"+jsonoriginial);
		
		String newFileName=System.getProperty("user.dir")+"\\Files\\jasonfile"+".json";
		File f = new File(newFileName);
		System.out.println(newFileName);
		FileWriter fileWriter = new FileWriter(newFileName);
		fileWriter.write(jsonoriginial.toString());
		fileWriter.flush();
	}

	private static JSONObject getPortsJson(String[] nam, JSONObject json2) {
		//String strports =nam[5].replaceAll("/TCP", "").replaceAll("/UDP", "");
		String strports =nam[5];
		JSONObject portsjson = new JSONObject();
		//JSONObject json2 = new JSONObject();
		if(strports.contains(","))
		{
			String multipleports[]=strports.split(",");
			for(int i=0;i<multipleports.length;i++)
			{
				String[] ports= multipleports[i].split(":");
    			if(ports.length==0 || ports.length==1)
    			portsjson.put(multipleports[i], "");
    			else
    				portsjson.put(ports[0], ports[1]);
			}
			json2.put(nam[1], portsjson);
		}
		else
		{
		String[] ports= strports.split(":");
		if(ports.length==0 || ports.length==1)
			portsjson.put(strports, "");
			else
				portsjson.put(ports[0], ports[1]);
		json2.put(nam[1], portsjson);
		}
		return json2;
	}
	

}

