package com.designpattern.TemplateDesignPattern;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;


public class Testrr
{

	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerException
	{
		String initaesdkRequest = "<InitAesdkRequest>" + "\n"
				+ "<ConfigFilePath>/home/sjonnalagadda/Desktop/APTOS/</ConfigFilePath>" + "\n" + "<PEDMaps>" + "\n"
				+ "<PEDMap>" + "\n" + "<POSID>01</POSID>" + "\n" + "<LANENO>01</LANENO>" + "\n" + "</PEDMap>" + "\n"
				+ "<PEDMap>" + "\n" + "<POSID>02</POSID>" + "\n" + "<LANENO>2</LANENO>" + "\n" + "</PEDMap>" + "\n"
				+ "</PEDMaps>" + "\n" + "</InitAesdkRequest>" + "\n";
		
		stringToDom(initaesdkRequest);
	}
	
	
	public static void stringToDom(String xmlSource) throws SAXException, ParserConfigurationException, IOException, TransformerException{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));
	    // Use a Transformer for output
	    TransformerFactory tFactory = TransformerFactory.newInstance();
	    Transformer transformer = tFactory.newTransformer();

	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult(new File("src/test_pp.xml"));
	    transformer.transform(source, result);
	    
	    
	    java.io.FileWriter fw = new java.io.FileWriter("src/my-file.xml");
	    fw.write(xmlSource);
	    fw.close();
	    
	    
	}  
}
