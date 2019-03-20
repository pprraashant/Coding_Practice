package com.java.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONParser {

	public void parse(String json) throws JsonProcessingException, IOException {
		JsonFactory factory = new JsonFactory();
		System.out.println("");
		boolean valuenode = false;
		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = mapper.readTree(json);

		if (rootNode.isValueNode())
			valuenode = true;
		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			if (valuenode)
				System.out.println("Keys:" + field.getKey() + " Value:" + field.getValue());
			if (field.getValue() instanceof JsonNode) {
				if (field.getValue() instanceof ArrayNode) {
					ArrayNode arraynode = (ArrayNode) field.getValue();
					Iterator<JsonNode> fieldsIteratorarraynode = arraynode.elements();

					while (fieldsIteratorarraynode.hasNext()) {
						JsonNode field_arraynode = fieldsIteratorarraynode.next();
						// System.out.println("Key: " + field_arraynode.getKey()
						// + "\tValue:" + field_arraynode.getValue());
						// if(field_arraynode.isValueNode())

						parse(field_arraynode.toString());

					}
				} else {
					parse(field.getValue().toString());
				}
			}

		}
	}
	public JSONObject GetJSONOjectContainigValue(String json,String value) {
		try{
		JsonFactory factory = new JsonFactory();
		System.out.println("");
		boolean valuenode = false;
		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = mapper.readTree(json);
System.out.println(rootNode.traverse().getCurrentName());
		JsonNode parentnode= rootNode.findPath("$.accounts");
		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = parentnode.fields();
		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			
				System.out.println("Keys:" + field.getKey() + " Value:" + field.getValue());
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return new JSONObject();
	}

	public void parseJSON(String json) throws JsonProcessingException, IOException {

		JSONObject jsonobj = new JSONObject(json);

		String[] jsonnamesString = jsonobj.getNames(jsonobj);
		for (String name : jsonnamesString) {
			System.out.println(name);
		}

		Set<String> keys = jsonobj.keySet();
		Iterator it = jsonobj.keys();
		while (it.hasNext()) {

			System.out.println(jsonobj.get(it.next().toString()));

		}
		for (String name : jsonnamesString) {
			System.out.println(name);
		}

	}
	public JSONArray JSONParseUsingJSONPathReturnJSONArray(String json, String jsonpath) {
			Object response = null;
		String projectPath = System.getProperty("user.dir");
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		// read script file
		try {
			engine.eval(Files.newBufferedReader(Paths.get(projectPath + "/JavaScripts/JSONPathLib.js"),
					StandardCharsets.UTF_8));
			Invocable inv = (Invocable) engine;
			engine.put("dataModel", json);
			Object obj1 = engine.eval("JSON.parse(dataModel)");
			response = inv.invokeFunction("jsonPath", obj1, jsonpath);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		response = convert(response);
		JSONArray json1 = null;
		if (response instanceof Boolean) {
			return json1;
		} else if (response instanceof Object) {
			Object[] obj = (Object[]) response;
			json1 = new JSONArray(obj);

		}
		return json1;
	}

	public JSONObject JSONParseUsingJSONPathReturnJSONObject(String json, String jsonpath) {
		Object response = null;
		String projectPath = System.getProperty("user.dir");
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		// read script file
		try {
			engine.eval(Files.newBufferedReader(Paths.get(projectPath + "/JavaScripts/JSONPathLib.js"),
					StandardCharsets.UTF_8));

			Invocable inv = (Invocable) engine;
			engine.put("dataModel", json);
			Object obj1 = engine.eval("JSON.parse(dataModel)");
			// call function from script file
			response = inv.invokeFunction("jsonPath", obj1, jsonpath);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		response = convert(response);// Convert ScriptObjectMirror to Java Object
		JSONObject json1 = null;
		if (response instanceof Boolean) {
			return json1;
		} else if (response instanceof Object) {
			Object obj = (Object) response;
			json1 = new JSONObject(obj);

		}
		return json1;
	}

	private static Object convert(final Object obj) 
	{

		if (obj instanceof Bindings) {
			try {
				final Class<?> cls = Class.forName("jdk.nashorn.api.scripting.ScriptObjectMirror");
				if (cls.isAssignableFrom(obj.getClass())) {
					final Method isArray = cls.getMethod("isArray");
					final Object result = isArray.invoke(obj);
					if (result != null && result.equals(true)) {
						final Method values = cls.getMethod("values");
						final Object vals = values.invoke(obj);
						if (vals instanceof Collection<?>) {
							final Collection<?> coll = (Collection<?>) vals;
							return coll.toArray(new Object[0]);
						}
					}
				}
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
			}
		}
		if (obj instanceof List<?>) {
			final List<?> list = (List<?>) obj;
			return list.toArray(new Object[0]);
		}
		return obj;
	}

	public String XpathParseUsingXPath(String filename, String xpath_exp) 
	{
		System.out.println("");
		String valueatnode="";
		try{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();;
        Document doc = builder.parse(filename);
        // Create XPathFactory for creating XPath Object
        XPathFactory xPathFactory = XPathFactory.newInstance();
        // Create XPath object from XPathFactory
        XPath xpath = xPathFactory.newXPath();
        // Compile the XPath expression for getting all brands
        XPathExpression xPathExpr = xpath.compile(xpath_exp);
        // XPath text example : executing xpath expression in java
        Object result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
        	valueatnode=valueatnode+"_"+nodes.item(i).getNodeValue();
        }
       	}
		catch(Exception e)
		{
			System.out.println(e);
		}
        return valueatnode.replaceFirst("_", "").trim();
        // https://javarevisited.blogspot.com/2012/12/create-and-evaluate-xpath-java-example-tutorial-program.html#ixzz5gjNHLI8C
	}
	public void printXpathResult(Object result){
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }


	public static void main(String[] args) throws JsonProcessingException, IOException {
		JSONParser jsonparser = new JSONParser();
		Long starttime = System.currentTimeMillis();

		System.out.println(System.currentTimeMillis());
		// File jsonfile= new
		// File(System.getProperty("user.dir")+"\\JSON\\orderTermsAndConditions.json");
		File jsonfile = new File(System.getProperty("user.dir") + "\\JSON\\Order.json");
		String jsonString = null;
		if (jsonfile.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(jsonfile));

			jsonString = br.lines().collect(Collectors.joining("\n"));
		}
			// jsonparser.parse(jsonString);
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString, "$.accounts"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$.productGroups.group[0].characteristics.losgCharacteristics"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$.productGroups.group[0].characteristics.losgCharacteristics.losgType"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$.promotions.promotions[0].promotionCode"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$..promotionCode"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$..accountCategory"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$..paymentOption"));
		System.out.println(jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,
				"$.promotions"));
		// jsonparser.parseJSON(jsonString);
		long endtime = System.currentTimeMillis();
		System.out.println("Total time in Miliseconds:" + (starttime - endtime));
		
		File xmlfile = new File(System.getProperty("user.dir") + "\\OCEData\\AuthorizeCreditCard.xml");
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\AuthorizeCreditCard.xml", "//firstName/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\AuthorizeCreditCard.xml", "//CreditCard/creditCardNumber/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\CRU-Mobility\\CRUACCOnly.xml", "//CustomerOrderNumber/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\CRU-Mobility\\CRUACCOnly.xml", "//OceBitMap/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\CRU-Mobility\\CRUACCOnly.xml", "//LineItems/LineItem[2]/DisplayName/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\CRU-Mobility\\CRUACCOnly.xml", "//LineItems/LineItem[2]/Price/Amount/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\CRU-Mobility\\CRUACCOnly.xml", "//ProductCode/text()"));
		System.out.println(jsonparser.XpathParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\test.xml", "//NewProductsInNewOffer/offerId/text()"));
		System.out.println(JSONParser.XMLParseUsingXPath(System.getProperty("user.dir") + "\\OCEData\\xmls\\test.xml", "//NewProductsInNewOffer/offerId/text()"));
		
		////////////////////////////////////////////////////////
		System.out.println(jsonparser.GetJSONOjectContainigValue(jsonString, "DTVNOW_ACCOUNT"));
		
		
		JSONArray output=jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,"$.productGroups.group[0].characteristics.losgCharacteristics.losgType");
		System.out.println(output.getString(0));
		
		JSONArray output2=jsonparser.JSONParseUsingJSONPathReturnJSONArray(jsonString,"$..paymentOption");
		System.out.println(output2.getJSONObject(0));
		jsonparser.checkoutput(jsonString);
		
		}
	public void checkoutput(String jsonString) throws FileNotFoundException
	{
		try
		{
			System.out.println("");
		JSONArray output2=JSONParseUsingJSONPathReturnJSONArray(jsonString,"$..paymentOption");
		System.out.println(output2.length());
		System.out.println(output2.getJSONObject(0).query("/0/paymentMethod/creditCard/creditCardNumber"));
		JSONObject json01= new JSONObject(jsonString);
		Object objresp=json01.query("/paymentOptions/paymentOption");
		JSONObject jsonarray01=null;
		if(objresp instanceof JSONObject)
		{
			jsonarray01=new JSONObject(objresp);
		}
		else if(objresp instanceof JSONArray)
		{
			output2= new JSONArray(objresp.toString());
			
		}
		System.out.println(output2.length());
		for(int i=0;i<output2.length();i++)
		{
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static List<String> XMLParseUsingXPath(String filename, String xpath_exp) {
		System.out.println("");
		List<String> valueatnode =  new ArrayList<String>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			;
			Document doc = builder.parse(filename);
			// Create XPathFactory for creating XPath Object
			XPathFactory xPathFactory = XPathFactory.newInstance();
			// Create XPath object from XPathFactory
			XPath xpath = xPathFactory.newXPath();
			// Compile the XPath expression for getting all brands
			XPathExpression xPathExpr = xpath.compile(xpath_exp);
			// XPath text example : executing xpath expression in java
			Object result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				valueatnode.add(nodes.item(i).getNodeValue());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return valueatnode;
		
	}
	}


