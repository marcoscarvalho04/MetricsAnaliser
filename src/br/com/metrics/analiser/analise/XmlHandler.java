package br.com.metrics.analiser.analise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import br.com.metrics.analiser.common.FileUtils;
import br.com.metrics.analiser.exception.ExceptionHandler;

public class XmlHandler  {
	
	public Document lerXml(){
		try {
			FileUtils fileUtils = new FileUtils();
			File xmlFile = fileUtils.lerArquivo("C:\\metricas\\metricas.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			doc.getDocumentElement().normalize();
			return doc;
			
		} catch (FileNotFoundException e) {
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
			return null;
		} catch (ParserConfigurationException e) {
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
			return null;
		} catch (IOException e) {
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
			return null;
		} catch (SAXException e) {
			ExceptionHandler.logarExcecao(e.getStackTrace().toString());
			return null;
		}
	}
		
}
